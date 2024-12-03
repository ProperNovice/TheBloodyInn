package gameStates;

import cards.Guest;
import enums.EGuestType;
import enums.EText;
import states.WagesNeedToBePaid;

public class DiscardCardsForPayingWages extends DiscardCardsForAction {

	@Override
	protected EText getETextShowing() {
		return EText.CHOOSE_CARDS_TO_DISCARD;
	}

	@Override
	protected int totalCardsNeedToDiscard() {
		return WagesNeedToBePaid.INSTANCE.get();
	}

	@Override
	protected EGuestType getGuestTypeToReturnToHand() {
		return null;
	}

	@Override
	protected Guest guestCantBeDiscarded() {
		return null;
	}

}
