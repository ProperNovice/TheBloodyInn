package gameStates;

import enums.EText;
import gameStatesDefault.GameState;

public class BribeGuest extends GameState {

	@Override
	public void execute() {

		EText.BRIBE_GUEST_INDICATOR.show();

	}

}
