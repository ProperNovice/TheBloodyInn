package gameStates;

import enums.EText;
import executions.GetGuestsToBuildAnnex;
import gameStatesDefault.GameState;
import utils.ArrayList;
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

		ArrayList<Class<? extends GameState>> list = new ArrayList<>();

		switch (eText) {

		case BRIBE_GUEST_OPTION:
			list.addLast(BribeGuest.class);
			break;

		case BUILD_ANNEX_OPTION:
			list.addLast(BuildAnnex.class);
			break;

		default:
			ShutDown.INSTANCE.execute();
			break;

		}

		flow().addAllFirst(list);
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
