package executions;

import cards.Guest;
import controller.Lists;

public enum AddGuestFromEntranceToReception {

	INSTANCE;

	public void execute() {

		Guest guest = Lists.INSTANCE.entrance.getArrayList().removeFirst();
		Lists.INSTANCE.reception.getArrayList().addFirst(guest);
		Lists.INSTANCE.reception.relocateImageViews();

	}

}
