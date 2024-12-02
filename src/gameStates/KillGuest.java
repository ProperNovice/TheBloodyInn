package gameStates;

import gameStatesDefault.GameState;

public class KillGuest extends GameState {

	@Override
	public void execute() {

		flow().addAllFirst(ChooseGuestToKill.class, DiscardCardsForKillingGuest.class);
		proceedToNextGameState();

	}

}
