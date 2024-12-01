package gameStates;

import cards.Guest;
import enums.EText;
import executions.GetGuestsToKill;
import gameStatesDefault.GameState;

public class KillGuest extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_GUEST_TO_KILL.show();

		for (Guest guest : GetGuestsToKill.INSTANCE.execute())
			guest.setSelected();

	}

}
