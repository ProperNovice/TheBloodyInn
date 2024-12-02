package gameStates;

import cards.Guest;
import enums.EGuestType;
import enums.EText;
import states.CorpseBuried;
import utils.ArrayList;

public class DiscardCardsToBuryCorpse extends DiscardCardsForAction {

	@Override
	protected EText getETextShowing() {
		return EText.CHOOSE_CARDS_TO_DISCARD;
	}

	@Override
	protected int totalCardsNeedToDiscard() {
		return CorpseBuried.INSTANCE.get().getGuestModel().getRank();
	}

	@Override
	protected EGuestType getGuestTypeToReturnToHand() {
		return EGuestType.RELIGIOUS;
	}

	@Override
	protected ArrayList<Guest> guestsCantBeDiscarded() {
		return new ArrayList<>();
	}

}
