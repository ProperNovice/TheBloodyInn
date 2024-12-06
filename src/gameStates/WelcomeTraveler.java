package gameStates;

import enums.EText;
import executions.AddGuestFromEntranceToReception;
import executions.AddGuestFromReceptionToRoom;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;
import tokens.KeyTokenNeutral;
import tokens.Token;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class WelcomeTraveler extends GameState {

	@Override
	public void execute() {

		EText.EVENING.show();
		EText.CHOOSE_ROOM.show();

		AddGuestFromEntranceToReception.INSTANCE.execute();

		setRoomsAvailable();

	}

	@Override
	public void handleRoomPressed(Room room) {

		concealText();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		AddGuestFromReceptionToRoom.INSTANCE.execute(room);

		proceedToNextGameState();

	}

	private void setRoomsAvailable() {

		ArrayList<Room> roomsAvailable = new ArrayList<>();
		ArrayList<Room> roomsAvailableOnlyWithNeutralKey = new ArrayList<>();

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (!room.getGuestList().getArrayList().isEmpty())
				continue;

			roomsAvailable.addLast(room);
			room.setSelected();

			if (room.getTokensList().getArrayList().size() > 1)
				continue;

			Token token = room.getTokensList().getArrayList().getFirst();

			if (!(token instanceof KeyTokenNeutral))
				continue;

			roomsAvailableOnlyWithNeutralKey.addLast(room);

		}

		if (roomsAvailable.size() > roomsAvailableOnlyWithNeutralKey.size()
				&& roomsAvailable.size() > 1)
			return;

		handleRoomPressed(roomsAvailable.getFirst());

	}

}
