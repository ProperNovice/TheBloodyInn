package gameStates;

import enums.EText;
import executions.ShuffleExitToEntrance;
import gameStatesDefault.GameState;
import states.DeckRun;

public class ShuffleGuests extends GameState {

	@Override
	public void execute() {

		EText.SHUFFLE_GUESTS.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ShuffleExitToEntrance.INSTANCE.execute();
		DeckRun.INSTANCE.setSecond();

		proceedToNextGameState();

	}

}
