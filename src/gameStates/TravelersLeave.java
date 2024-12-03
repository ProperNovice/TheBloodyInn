package gameStates;

import enums.EText;
import executions.ExecuteTravelersLeave;
import gameStatesDefault.GameState;

public class TravelersLeave extends GameState {

	@Override
	public void execute() {

		EText.TRAVELERS_LEAVE.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ExecuteTravelersLeave.INSTANCE.execute();
		proceedToNextGameState();

	}

}
