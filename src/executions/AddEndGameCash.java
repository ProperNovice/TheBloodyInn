package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;
import enums.EGuestType;
import states.Statistics;

public enum AddEndGameCash {

	INSTANCE;

	public void execute() {

		for (Card card : Lists.INSTANCE.annex) {

			if (card.getImageView().isFlippedBack())
				continue;

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;

			EGuest eGuest = guest.getGuestModel().getEGuest();

			switch (eGuest) {

			case BISHOP:
				Statistics.INSTANCE
						.addCash(4 * getGuestsAtExitWithEGuestType(EGuestType.RELIGIOUS));

			case DUKE:
				Statistics.INSTANCE.addCash(4 * getGuestsAtExitWithEGuestType(EGuestType.NOBLE));

			case GROCER:
				Statistics.INSTANCE.addCash(4 * getGuestsAtExitWithEGuestType(EGuestType.MERCHANT));

			case LANDSCAPER:
				Statistics.INSTANCE.addCash(4 * getGuestsAtExitWithEGuestType(EGuestType.ARTISAN));

			case PRINCE:
				Statistics.INSTANCE.addCash(3 * Statistics.INSTANCE.getChecks());

			default:
				break;

			}

		}

	}

	private int getGuestsAtExitWithEGuestType(EGuestType eGuestType) {

		int count = 0;

		for (Guest guest : Lists.INSTANCE.exit) {

			if (!guest.getGuestModel().getEGuestType().equals(eGuestType))
				continue;

			count++;

		}

		return count;

	}

}
