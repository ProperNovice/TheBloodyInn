package gameStates;

import gameStatesDefault.GameState;

public class Evening extends GameState {

	@Override
	public void execute() {

		flow().addFirst(WelcomeTraveler.class, 4);
		proceedToNextGameState();

	}

}
