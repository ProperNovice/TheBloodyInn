package executions;

import cards.Guest;
import controller.Lists;
import utils.ArrayList;

public enum GetGuestsToBuildAnnex {

	INSTANCE;

	public ArrayList<Guest> execute() {

		ArrayList<Guest> list = new ArrayList<>();

		for (Guest guest : Lists.INSTANCE.hand) {

			if (!guest.getGuestModel().canBuildAnnex())
				continue;

			int guestRank = guest.getGuestModel().getRank();

			if (Lists.INSTANCE.hand.getArrayList().size() <= guestRank)
				continue;

			list.addLast(guest);

		}

		return list;

	}

}
