package gameStates;

import enums.EText;
import gameStatesDefault.GameState;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		EText.START_NEW_TURN.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		flow().addLast(Evening.class);
		flow().addLast(Night.class);
		flow().addLast(Morning.class);
		flow().addLast(EndTurn.class);

		proceedToNextGameState();

	}

}
