package gameStates;

import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;

public class JUnit extends GameState {

	@Override
	public void execute() {

		getFlow().addLast(SetUpGame.class);

		proceedToNextGameState();

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

	}

}
