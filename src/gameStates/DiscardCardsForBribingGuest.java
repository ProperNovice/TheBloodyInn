package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EGuestType;
import enums.EText;
import utils.ArrayList;

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
	protected ArrayList<Guest> guestsCantBeDiscarded() {

		ArrayList<Guest> list = new ArrayList<>();
		list.addLast(Lists.INSTANCE.hand.getArrayList().getLast());

		return list;

	}

}
