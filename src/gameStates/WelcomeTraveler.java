package gameStates;

import enums.EText;
import executions.AddGuestFromEntranceToReception;
import executions.AddGuestFromReceptionToRoom;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;
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

		ArrayList<Room> roomsAvailable = new ArrayList<>(1);

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (!room.getGuestList().getArrayList().isEmpty())
				continue;

			roomsAvailable.addLast(room);
			room.setSelected();

		}

		if (roomsAvailable.isOverCapacity())
			return;

		handleRoomPressed(roomsAvailable.getFirst());

	}

}
