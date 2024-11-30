package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EText;
import gameStatesDefault.GameState;

public class BribePeasant extends GameState {

	@Override
	public void execute() {

		EText.BRIBE_EXTRA_PEASANT.show();
		EText.DONT_BRIBE.show();
		Lists.INSTANCE.bistro.getArrayList().getFirst().setSelected();

	}

	@Override
	protected void executeTextOption(EText eText) {

	}

	@Override
	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {

	}

}
