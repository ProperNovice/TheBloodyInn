package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;
import enums.EGuestType;
import states.Statistics;

public enum AddGuestFromHandToAnnex {

	INSTANCE;

	public void execute(Guest guest) {

		Lists.INSTANCE.hand.getArrayList().remove(guest);
		Lists.INSTANCE.hand.relocateImageViews();

		Lists.INSTANCE.annex.getArrayList().addLast(guest);
		Lists.INSTANCE.annex.relocateImageViews();

		int guestRank = guest.getGuestModel().getRank();
		Statistics.INSTANCE.addAnnex(guestRank);

		handleAbilities(guest.getGuestModel().getEGuest());

	}

	private void handleAbilities(EGuest eGuest) {

		switch (eGuest) {

		case BARON:
			Statistics.INSTANCE.addCash(4);
			break;

		case VISCOUNT:
			Statistics.INSTANCE.addCash(6);
			break;

		case COUNT:
			Statistics.INSTANCE.addCash(9);
			break;

		case MARQUIS:
			Statistics.INSTANCE.addCash(18);
			break;

		case NEWSBOY:
			Statistics.INSTANCE.addCash(getAnnexesBuildOfEGuestType(EGuestType.MERCHANT));
			break;

		case NOVICE:
			Statistics.INSTANCE.addCash(getAnnexesBuildOfEGuestType(EGuestType.RELIGIOUS));
			break;

		case CULTIVATOR:
			Statistics.INSTANCE.addCash(getAnnexesBuildOfEGuestType(EGuestType.ARTISAN));
			break;

		case BISHOP:
			Statistics.INSTANCE.addCash(4);
			break;

		case DUKE:
			Statistics.INSTANCE.addCash(4);
			break;

		case GROCER:
			Statistics.INSTANCE.addCash(4);
			break;

		case LANDSCAPER:
			Statistics.INSTANCE.addCash(4);
			break;

		default:
			break;

		}

	}

	private int getAnnexesBuildOfEGuestType(EGuestType eGuestType) {

		int count = 0;

		for (Card card : Lists.INSTANCE.annex) {

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;

			if (!guest.getGuestModel().getEGuestType().equals(eGuestType))
				continue;

			if (guest.getImageView().isFlippedBack())
				continue;

			count++;

		}

		return count;

	}

}
