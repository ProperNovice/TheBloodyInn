package gameStates;

import controller.Lists;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;

public class JUnit extends GameState {

	@Override
	public void execute() {

		flow().addLast(SetUpGame.class);
		flow().addLast(Evening.class);
		flow().addLast(Night.class);

		Lists.INSTANCE.entrance.getArrayList().shuffle();
		Lists.INSTANCE.entrance.relocateImageViews();

		proceedToNextGameState();

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

	}

}
