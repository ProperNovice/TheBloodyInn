package gameStates;

import executions.AddEndGameCash;
import gameStatesDefault.GameState;

public class EndGame extends GameState {

	@Override
	public void execute() {

		AddEndGameCash.INSTANCE.execute();

	}

}
