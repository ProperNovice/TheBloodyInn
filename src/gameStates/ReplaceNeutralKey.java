package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EText;
import executions.ExecuteChooseKeyToReplace;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;
import tokens.KeyTokenNeutral;
import tokens.Token;

public class ReplaceNeutralKey extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_KEY_TO_REPLACE.show();

		for (Room room : Rooms.INSTANCE.getRooms()) {

			Token token = room.getTokensList().getArrayList().getFirst();

			if (!(token instanceof KeyTokenNeutral))
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
		ExecuteChooseKeyToReplace.INSTANCE.execute(room);
		proceedToNextGameState();

	}

}
