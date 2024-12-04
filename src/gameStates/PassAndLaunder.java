package gameStates;

import enums.EText;
import executions.Launder;
import gameStatesDefault.GameState;
import states.Statistics;

public class PassAndLaunder extends GameState {

	@Override
	public void execute() {

		if (Statistics.INSTANCE.getCash() < 10)
			proceedToNextGameState();

		else {

			EText.LAUNDER.show();
			EText.PASS.show();

		}

	}

	@Override
	protected void executeTextOption(EText eText) {

		if (eText.equals(EText.LAUNDER)) {

			Launder.INSTANCE.execute();
			flow().addFirst(PassAndLaunder.class);

		}

		proceedToNextGameState();

	}

}
