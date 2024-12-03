package gameStates;

import gameStatesDefault.GameState;

public class Morning extends GameState {

	@Override
	public void execute() {

		flow().addAllFirst(PoliceInvestigation.class, TravelersLeave.class, PayWages.class);
		proceedToNextGameState();

	}

}
