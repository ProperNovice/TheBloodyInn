package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EText;
import executions.AddGuestFromRoomToAnnexFlipBack;
import executions.AddPeasantFromBistroToAnnexFlipBack;
import executions.GetGuestsToKill;
import gameStatesDefault.GameState;
import model.Room;

public class ChooseGuestToKill extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_GUEST_TO_KILL.show();

		for (Guest guest : GetGuestsToKill.INSTANCE.execute())
			guest.setSelected();

		if (!Lists.INSTANCE.bistro.getArrayList().isEmpty())
			Lists.INSTANCE.bistro.getArrayList().getFirst().setSelected();

	}

	@Override
	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel, Room room) {

		if (!guest.isSelected())
			return;

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();
		AddGuestFromRoomToAnnexFlipBack.INSTANCE.execute(guest, room);

		proceedToNextGameState();

	}

	@Override
	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();
		AddPeasantFromBistroToAnnexFlipBack.INSTANCE.execute();

		proceedToNextGameState();

	}

}
