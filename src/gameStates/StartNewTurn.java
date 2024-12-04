package gameStates;

import gameStatesDefault.GameState;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		flow().addLast(Evening.class);
		flow().addLast(Night.class);
		flow().addLast(Morning.class);
		flow().addLast(StartNewTurn.class);

		proceedToNextGameState();

	}

}
