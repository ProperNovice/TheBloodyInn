package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;

public enum AnnexContainGuest {

	INSTANCE;

	public int execute(EGuest eGuest) {

		int count = 0;

		for (Card card : Lists.INSTANCE.annex) {

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;
			EGuest eGuestTemp = guest.getGuestModel().getEGuest();

			if (!eGuest.equals(eGuestTemp))
				continue;

			if (guest.getImageView().isFlippedBack())
				continue;

			count++;

		}

		return count;

	}

}
