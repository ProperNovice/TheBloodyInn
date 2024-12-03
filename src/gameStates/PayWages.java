package gameStates;

import enums.EText;
import executions.ExecutePayWages;
import gameStatesDefault.GameState;
import states.WagesNeedToBePaid;

public class PayWages extends GameState {

	@Override
	public void execute() {

		EText.PAY_WAGES.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ExecutePayWages.INSTANCE.execute();

		if (WagesNeedToBePaid.INSTANCE.get() > 0)
			flow().addFirst(DiscardCardsForPayingWages.class);

		proceedToNextGameState();

	}

}
