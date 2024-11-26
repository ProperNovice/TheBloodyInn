package gameStates;

import gameStatesDefault.GameState;

public class JUnit extends GameState {

	@Override
	public void execute() {

		getFlow().addLast(StartGame.class);
		proceedToNextGameState();

	}

}
