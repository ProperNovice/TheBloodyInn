package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;
import enums.EGuestType;
import states.Statistics;

public enum GetEndGameCash {

	INSTANCE;

	public int execute() {

		int count = 0;

		for (Card card : Lists.INSTANCE.annex) {

			if (card.getImageView().isFlippedBack())
				continue;

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;

			EGuest eGuest = guest.getGuestModel().getEGuest();

			switch (eGuest) {

			case BISHOP:
				count += 4 * getGuestsAtExitWithEGuestType(EGuestType.RELIGIOUS);

			case DUKE:
				count += 4 * getGuestsAtExitWithEGuestType(EGuestType.NOBLE);

			case GROCER:
				count += 4 * getGuestsAtExitWithEGuestType(EGuestType.MERCHANT);

			case LANDSCAPER:
				count += 4 * getGuestsAtExitWithEGuestType(EGuestType.ARTISAN);

			case PRINCE:
				count += 3 * Statistics.INSTANCE.getChecks();

			default:
				break;

			}

		}

		return count;

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
