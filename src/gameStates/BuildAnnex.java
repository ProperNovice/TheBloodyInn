package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EText;
import executions.AddGuestFromHandToAnnex;
import executions.GetGuestsToBuildAnnex;
import gameStatesDefault.GameState;

public class BuildAnnex extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_ANNEX_TO_BUILD.show();

		for (Guest guest : GetGuestsToBuildAnnex.INSTANCE.execute())
			guest.setSelected();

	}

	@Override
	protected void handleGuestPressedHand(Guest guest, GuestModel guestModel) {

		if (!guest.isSelected())
			return;

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();

		AddGuestFromHandToAnnex.INSTANCE.execute(guest);

		if (guestModel.getRank() > 0)
			flow().addFirst(DiscardCardsForBuildingAnnex.class);

		proceedToNextGameState();

	}

}
