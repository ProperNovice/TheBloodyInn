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

		// checking for monk

		Card card = Lists.INSTANCE.annex.getArrayList().getLast();
		Guest guest = (Guest) card;

		if (!guest.getGuestModel().getEGuest().equals(EGuest.MONK))
			return;

		flow().addFirst(ReplaceNeutralKey.class);

	}

}
