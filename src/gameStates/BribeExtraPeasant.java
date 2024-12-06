package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EText;
import executions.AddPeasantFromBistroToHand;
import gameStatesDefault.GameState;
import states.PeasantsCanBeBribed;

public class BribeExtraPeasant extends GameState {

	@Override
	public void execute() {

		if (!Lists.INSTANCE.bistro.getArrayList().isEmpty()
				&& PeasantsCanBeBribed.INSTANCE.canBeBribed()) {

			EText.BRIBE_EXTRA_PEASANT.show();
			EText.DONT_BRIBE.show();
			Lists.INSTANCE.bistro.getArrayList().getFirst().setSelected();

		} else
			proceedToNextGameState();

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

		AddPeasantFromBistroToHand.INSTANCE.execute(1);
		PeasantsCanBeBribed.INSTANCE.reducePeasantBribed();

		executeGameState(this.getClass());

	}

}
