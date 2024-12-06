package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EText;
import executions.ExecutePlaceServiceToken;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;

public class PlaceRoomServiceToken extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_ROOM_TO_PLACE_SERCVICE.show();

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getTokensList().getArrayList().size() == 2)
				continue;

			room.setSelected();

		}

	}

	@Override
	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel, Room room) {
		handleRoomPressed(room);
	}

	@Override
	public void handleRoomPressed(Room room) {

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();
		ExecutePlaceServiceToken.INSTANCE.execute(room);
		proceedToNextGameState();

	}

}
