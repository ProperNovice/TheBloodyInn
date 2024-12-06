package gameStates;

import controller.Lists;
import enums.EText;
import executions.ShuffleExitToEntrance;
import gameStatesDefault.GameState;
import states.DeckRun;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		EText.START_NEW_TURN.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		if (Lists.INSTANCE.entrance.getArrayList().isEmpty()) {

			ShuffleExitToEntrance.INSTANCE.execute();
			DeckRun.INSTANCE.setSecond();

		}

		flow().addLast(Evening.class);
		flow().addLast(Night.class);
		flow().addLast(Morning.class);
		flow().addLast(StartNewTurn.class);

		proceedToNextGameState();

	}

}
