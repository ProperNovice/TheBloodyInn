package executions;

import cards.Guest;
import controller.Lists;
import utils.ArrayList;

public enum ShuffleExitToEntrance {

	INSTANCE;

	public void execute() {

		ArrayList<Guest> list = Lists.INSTANCE.exit.getArrayList().clear();
		Lists.INSTANCE.entrance.getArrayList().addAllLast(list);
		Lists.INSTANCE.entrance.getArrayList().shuffle();

		Lists.INSTANCE.entrance.relocateImageViews();

	}

}
