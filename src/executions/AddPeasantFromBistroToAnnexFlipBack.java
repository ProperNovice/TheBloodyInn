package executions;

import cards.Guest;
import controller.Lists;

public enum AddPeasantFromBistroToAnnexFlipBack {

	INSTANCE;

	public void execute() {

		Guest guest = Lists.INSTANCE.bistro.getArrayList().removeFirst();
		guest.getImageView().flipBack();
		Lists.INSTANCE.annex.getArrayList().addLast(guest);
		Lists.INSTANCE.annex.relocateImageViews();

	}

}
