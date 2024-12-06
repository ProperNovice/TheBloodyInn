package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import enums.EGuest;
import utils.ArrayList;

public enum GetCorpsesToBury {

	INSTANCE;

	public ArrayList<Guest> execute() {

		ArrayList<Guest> list = new ArrayList<>();

		for (Card card : Lists.INSTANCE.annex) {

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;

			if (guest.getImageView().isFlippedFront())
				continue;

			int rank = guest.getGuestModel().getRank();
			int abbotGuest = AnnexContainGuest.INSTANCE.execute(EGuest.ABBOT);

			if (Lists.INSTANCE.hand.getArrayList().size() + abbotGuest < rank)
				continue;

			list.addLast(guest);

		}

		return list;

	}

}
