package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EText;
import executions.ExecuteBribeGuest;
import executions.SetUpGuestsSelected;
import gameStatesDefault.GameState;
import states.PeasantsCanBeBribed;

public class BribePeasant extends GameState {

	@Override
	public void execute() {

		EText.BRIBE_EXTRA_PEASANT.show();
		EText.DONT_BRIBE.show();
		Lists.INSTANCE.bistro.getArrayList().getFirst().setSelected();

		SetUpGuestsSelected.INSTANCE.execute();

	}

	@Override
	protected void executeTextOption(EText eText) {

		getSelectImageViewManager().releaseSelectImageViews();
		proceedToNextGameState();

	}

	@Override
	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {

		concealText();

		getSelectImageViewManager().releaseSelectImageViews();
		ExecuteBribeGuest.INSTANCE.execute();

		PeasantsCanBeBribed.INSTANCE.reducePeasantBribed();

		if (!Lists.INSTANCE.bistro.getArrayList().isEmpty())
			if (PeasantsCanBeBribed.INSTANCE.canBeBribed())
				flow().addFirst(this.getClass());

		proceedToNextGameState();

	}

}
