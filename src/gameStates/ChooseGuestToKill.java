package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EText;
import executions.GetGuestsToKill;
import gameStatesDefault.GameState;
import model.Room;

public class ChooseGuestToKill extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_GUEST_TO_KILL.show();

		for (Guest guest : GetGuestsToKill.INSTANCE.execute())
			guest.setSelected();

	}

	@Override
	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel, Room room) {

		if (!guest.isSelected())
			return;

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();
		room.getGuestList().getArrayList().removeFirst();
		Lists.INSTANCE.annex.getArrayList().addLast(guest);
		guest.getImageView().flipBack();

		Lists.INSTANCE.annex.relocateImageViews();

		proceedToNextGameState();

	}

}
