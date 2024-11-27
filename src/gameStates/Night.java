package gameStates;

import gameStatesDefault.GameState;

public class Night extends GameState {

	@Override
	public void execute() {

		flow().addAllFirst(ChooseActionOne.class, ChooseActionTwo.class);
		proceedToNextGameState();

	}

}
