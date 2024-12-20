package gameStates;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;
import enums.EGuestType;
import enums.EText;

public class DiscardCardsForBuildingAnnex extends DiscardCardsForAction {

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
		return EGuestType.ARTISAN;
	}

	@Override
	protected Guest guestCantBeDiscarded() {
		return null;
	}

	@Override
	protected EGuest guestInAnnexToLowerDiscardCost() {
		return EGuest.MECHANIC;
	}

	@Override
	protected void executeBeforeProceedToNextGameState() {

		// checking for guest

		Card card = Lists.INSTANCE.annex.getArrayList().getLast();
		Guest guest = (Guest) card;

		switch (guest.getGuestModel().getEGuest()) {

		case MONK:
			flow().addFirst(ReplaceNeutralKey.class);
			break;

		case CONCIERGE:
			flow().addFirst(PlaceRoomServiceToken.class);
			break;

		default:
			break;

		}

	}

}
