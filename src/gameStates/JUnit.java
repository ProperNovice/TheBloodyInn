package gameStates;

import cards.Guest;
import enums.EGuest;
import gameStatesDefault.GameState;

public class JUnit extends GameState {

	@Override
	public void execute() {

		for (EGuest eGuest : EGuest.values())
			new Guest(eGuest).handleMousePressedPrimary();

	}

}
