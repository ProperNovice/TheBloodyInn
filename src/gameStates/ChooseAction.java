package gameStates;

import enums.EText;
import executions.GetCorpsesToBury;
import executions.GetGuestsToBuildAnnex;
import executions.GetGuestsToKill;
import gameStatesDefault.GameState;
import model.Statistics;
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

		case KILL_GUEST:
			list.addLast(KillGuest.class);
			break;

		case BURY_CORPSE:
			list.addLast(BuryCorpse.class);
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

		if (!GetGuestsToKill.INSTANCE.execute().isEmpty())
			EText.KILL_GUEST.show();

	}

	private void buryCorpse() {

		if (GetCorpsesToBury.INSTANCE.execute().isEmpty())
			return;

		if (Statistics.INSTANCE.getAnnexAvailable() == 0)
			return;

		EText.BURY_CORPSE.show();

	}

	private void passAndLaunder() {

	}

	protected abstract int getAction();

}
