package gameStates;

import gameStatesDefault.GameState;

public class BuryCorpse extends GameState {

	@Override
	public void execute() {

		flow().addAllFirst(ChooseCorpseToBury.class, DiscardCardsToBuryCorpse.class);
		proceedToNextGameState();

	}

}
