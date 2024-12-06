package gameStates;

import controller.Lists;
import gameStatesDefault.GameState;
import states.DeckRun;

public class EndTurn extends GameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.entrance.getArrayList().size() < 4) {

			if (DeckRun.INSTANCE.get() == 1)
				flow().addAllLast(ShuffleGuests.class, StartNewTurn.class);

			else
				flow().addLast(ProceedToEndGame.class);

		} else
			flow().addLast(StartNewTurn.class);

		proceedToNextGameState();

	}

}
