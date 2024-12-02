package executions;

import cards.Guest;
import controller.Lists;

public enum AddGuestFromHandToAnnex {

	INSTANCE;

	public void execute(Guest guest) {

		Lists.INSTANCE.hand.getArrayList().remove(guest);
		Lists.INSTANCE.hand.relocateImageViews();

		Lists.INSTANCE.annex.getArrayList().addLast(guest);
		Lists.INSTANCE.annex.relocateImageViews();

	}

}
