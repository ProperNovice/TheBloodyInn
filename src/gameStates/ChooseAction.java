package gameStates;

import enums.EText;
import executions.GetGuestsToBuildAnnex;
import gameStatesDefault.GameState;
import utils.ShutDown;

public abstract class ChooseAction extends GameState {

	@Override
	public void execute() {

		EText.NIGHT.show();
		EText.ACTION.showAdditionally(getAction());
//		EText.CHOOSE_ACTION.show();

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

		case BUILD_ANNEX_OPTION:
			gameStateClass = ChooseAnnexToBuild.class;
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

		if (!GetGuestsToBuildAnnex.INSTANCE.execute().isEmpty())
			EText.BUILD_ANNEX_OPTION.show();

	}

	private void killGuest() {

	}

	private void buryCorpse() {

	}

	private void passAndLaunder() {

	}

	protected abstract int getAction();

}
