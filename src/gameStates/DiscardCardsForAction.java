package gameStates;

import java.util.ArrayList;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EGuestType;
import enums.EText;
import gameStatesDefault.GameState;
import utils.ListImageViewAbles;

public abstract class DiscardCardsForAction extends GameState {

	@Override
	public void execute() {

		getETextShowing().show();

		int cardsSelected = getSelectImageViewManager().getSelectedImageViewAbles().size();

		if (cardsSelected == totalCardsNeedToDiscard())
			EText.CONTINUE_OPTION.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		for (Guest guest : Lists.INSTANCE.hand.getArrayList().clone()) {

			if (!guest.isSelected())
				continue;

			if (getGuestTypeToReturnToHand() != null)
				if (guest.getGuestModel().getEGuestType().equals(getGuestTypeToReturnToHand()))
					continue;

			Lists.INSTANCE.hand.getArrayList().remove(guest);
			Lists.INSTANCE.hand.relocateImageViews();

			ListImageViewAbles<Guest> list = null;

			if (guest.getGuestModel().getEGuestType().equals(EGuestType.PEASANT))
				list = Lists.INSTANCE.bistro;
			else
				list = Lists.INSTANCE.exit;

			list.getArrayList().addFirst(guest);
			list.relocateImageViews();

		}

		getSelectImageViewManager().releaseSelectImageViews();

		proceedToNextGameState();

	}

	@Override
	protected void handleGuestPressedHand(Guest guest, GuestModel guestModel) {

		if (guestsCantBeDiscarded().contains(guest))
			return;

		concealText();
		guest.reverseSelected();
		execute();

	}

	protected abstract EText getETextShowing();

	protected abstract int totalCardsNeedToDiscard();

	protected abstract EGuestType getGuestTypeToReturnToHand();

	protected abstract ArrayList<Guest> guestsCantBeDiscarded();

}
