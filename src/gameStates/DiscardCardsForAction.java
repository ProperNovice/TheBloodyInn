package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EGuest;
import enums.EGuestType;
import enums.EText;
import executions.AnnexContainGuest;
import gameStatesDefault.GameState;
import utils.ListImageViewAbles;

public abstract class DiscardCardsForAction extends GameState {

	private int totalCardsNeedToDiscard = -1;

	@Override
	public void execute() {

		setTotalCardsNeedToDiscard();

		if (this.totalCardsNeedToDiscard == 0) {

			proceedToNextGameState();
			return;

		}

		getETextShowing().show();

		int cardsSelected = getSelectImageViewManager().getSelectedImageViewAbles().size();

		if (cardsSelected == this.totalCardsNeedToDiscard)
			EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		for (Guest guest : Lists.INSTANCE.hand.getArrayList().clone()) {

			if (!guest.isSelected())
				continue;

			Lists.INSTANCE.hand.getArrayList().remove(guest);

			ListImageViewAbles<Guest> list = null;

			if (getGuestTypeToReturnToHand() != null
					&& guest.getGuestModel().getEGuestType().equals(getGuestTypeToReturnToHand()))
				list = Lists.INSTANCE.hand;

			else if (guest.getGuestModel().getEGuestType().equals(EGuestType.PEASANT))
				list = Lists.INSTANCE.bistro;
			else
				list = Lists.INSTANCE.exit;

			if (list.equals(Lists.INSTANCE.hand))
				list.getArrayList().addLast(guest);
			else
				list.getArrayList().addFirst(guest);

			list.relocateImageViews();

		}

		Lists.INSTANCE.hand.relocateImageViews();
		Lists.INSTANCE.bistro.relocateImageViews();
		Lists.INSTANCE.exit.relocateImageViews();

		getSelectImageViewManager().releaseSelectImageViews();

		executeBeforeProceedToNextGameState();
		proceedToNextGameState();

	}

	@Override
	protected void handleGuestPressedHand(Guest guest, GuestModel guestModel) {

		if (guestCantBeDiscarded() != null && guestCantBeDiscarded().equals(guest))
			return;

		concealText();
		guest.reverseSelected();
		execute();

	}

	private void setTotalCardsNeedToDiscard() {

		this.totalCardsNeedToDiscard = totalCardsNeedToDiscard();

		if (guestInAnnexToLowerDiscardCost() == null)
			return;

		int count = AnnexContainGuest.INSTANCE.execute(guestInAnnexToLowerDiscardCost());

		this.totalCardsNeedToDiscard -= count;
		this.totalCardsNeedToDiscard = Math.max(this.totalCardsNeedToDiscard, 0);

	}

	protected abstract EText getETextShowing();

	protected abstract int totalCardsNeedToDiscard();

	protected abstract EGuest guestInAnnexToLowerDiscardCost();

	protected abstract EGuestType getGuestTypeToReturnToHand();

	protected abstract Guest guestCantBeDiscarded();

	protected abstract void executeBeforeProceedToNextGameState();

}
