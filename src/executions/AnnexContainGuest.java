package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;
import utils.ArrayList;

public enum AnnexContainGuest {

	INSTANCE;

	public int execute(EGuest eGuest) {

		int count = 0;

		ArrayList<Card> list = Lists.INSTANCE.annex.getArrayList().clone();

		for (Card card : list) {

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
