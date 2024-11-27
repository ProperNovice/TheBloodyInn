package gameStates;

import controller.Lists;
import enums.EText;
import gameStatesDefault.GameState;
import utils.ShutDown;

public abstract class ChooseAction extends GameState {

	@Override
	public void execute() {

		EText.NIGHT.show();
		EText.ACTION.showAdditionally(getAction());
		EText.CHOOSE_ACTION.show();

		bribeGuest();
		buildAnnex();
		killGuest();
		buryCorpse();
		passAndLaunder();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Class<? extends GameState> gameStateClass = null;

		switch (eText) {

		case BRIBE_GUEST_OPTION:
			gameStateClass = BribeGuest.class;
			break;

		default:
			ShutDown.INSTANCE.execute();
			break;

		}

		flow().addFirst(gameStateClass);
		proceedToNextGameState();

	}

	private void bribeGuest() {
		EText.BRIBE_GUEST_OPTION.show();
	}

	private void buildAnnex() {

		if (Lists.INSTANCE.hand.getArrayList().isEmpty())
			return;

	}

	private void killGuest() {

	}

	private void buryCorpse() {

	}

	private void passAndLaunder() {

	}

	protected abstract int getAction();

}
