package gameStates;

import enums.EText;
import executions.ExecutePoliceInvestigation;
import gameStatesDefault.GameState;

public class PoliceInvestigation extends GameState {

	@Override
	public void execute() {

		EText.POLICE_INVESTIGATION.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ExecutePoliceInvestigation.INSTANCE.execute();
		proceedToNextGameState();

	}

}
