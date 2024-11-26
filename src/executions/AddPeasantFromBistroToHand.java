package executions;

import cards.Guest;
import controller.Lists;

public enum AddPeasantFromBistroToHand {

	INSTANCE;

	public void execute(int amount) {

		if (amount == 0)
			return;

		Guest guest = Lists.INSTANCE.bistro.getArrayList().removeFirst();
		Lists.INSTANCE.hand.getArrayList().addLast(guest);
		Lists.INSTANCE.hand.relocateImageViews();

		execute(amount - 1);

	}

}
