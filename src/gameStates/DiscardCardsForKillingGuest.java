package gameStates;

import java.util.ArrayList;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuestType;
import enums.EText;

public class DiscardCardsForKillingGuest extends DiscardCardsForAction {

	@Override
	protected EText getETextShowing() {
		return EText.CHOOSE_CARDS_TO_DISCARD;
	}

	@Override
	protected int totalCardsNeedToDiscard() {

		Card card = Lists.INSTANCE.annex.getArrayList().getLast();
		Guest guest = (Guest) card;
		return guest.getGuestModel().getRank();

	}

	@Override
	protected EGuestType getGuestTypeToReturnToHand() {
		return EGuestType.POLICE;
	}

	@Override
	protected ArrayList<Guest> guestsCantBeDiscarded() {
		return new ArrayList<>();
	}

}
