package gameStates;

import gameStatesDefault.EndGameLost;
import gameStatesDefault.EndGameWon;
import gameStatesDefault.GameState;
import states.Statistics;

public class ProceedToEndGame extends GameState {

	@Override
	public void execute() {

		if (Statistics.INSTANCE.getTotal() >= 170)
			flow().addFirst(EndGameWon.class);
		else
			flow().addFirst(EndGameLost.class);

		proceedToNextGameState();

	}

}
