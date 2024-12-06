package executions;

import cards.Guest;
import controller.Lists;
import enums.EGuest;
import utils.ArrayList;

public enum GetGuestsToBuildAnnex {

	INSTANCE;

	public ArrayList<Guest> execute() {

		ArrayList<Guest> list = new ArrayList<>();

		for (Guest guest : Lists.INSTANCE.hand) {

			if (!guest.getGuestModel().canBuildAnnex())
				continue;

			int guestRank = guest.getGuestModel().getRank();

			int mechanicGuest = AnnexContainGuest.INSTANCE.execute(EGuest.MECHANIC);

			if (Lists.INSTANCE.hand.getArrayList().size() + mechanicGuest <= guestRank)
				continue;

			list.addLast(guest);

		}

		return list;

	}

}
