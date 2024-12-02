package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EText;
import executions.GetGuestsToBuildAnnex;
import gameStatesDefault.GameState;
import model.Statistics;

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

		Lists.INSTANCE.hand.getArrayList().remove(guest);
		Lists.INSTANCE.hand.relocateImageViews();

		Lists.INSTANCE.annex.getArrayList().addLast(guest);
		Lists.INSTANCE.annex.relocateImageViews();

		int guestRank = guest.getGuestModel().getRank();
		Statistics.INSTANCE.addAnnex(guestRank);

		if (guestModel.getRank() > 0)
			flow().addFirst(DiscardCardsForBuildingAnnex.class);

		proceedToNextGameState();

	}

}
