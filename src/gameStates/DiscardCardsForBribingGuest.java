package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EGuestType;
import enums.EText;

public class DiscardCardsForBribingGuest extends DiscardCardsForAction {

	@Override
	protected EText getETextShowing() {
		return EText.CHOOSE_CARDS_TO_DISCARD;
	}

	@Override
	protected int totalCardsNeedToDiscard() {

		Guest guest = Lists.INSTANCE.hand.getArrayList().getLast();
		return guest.getGuestModel().getRank();

	}

	@Override
	protected EGuestType getGuestTypeToReturnToHand() {
		return EGuestType.MERCHANT;
	}

	@Override
	protected Guest guestCantBeDiscarded() {
		return Lists.INSTANCE.hand.getArrayList().getLast();

	}

}
