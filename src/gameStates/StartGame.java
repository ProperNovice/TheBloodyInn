package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EText;
import executions.AddPeasantFromBistroToHand;
import gameStatesDefault.GameState;

public class StartGame extends GameState {

	@Override
	public void execute() {

		EText.START_GAME.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		prepareGuests();
		addPeasants();

	}

	private void addPeasants() {
		AddPeasantFromBistroToHand.INSTANCE.execute(2);
	}

	private void prepareGuests() {

		Lists.INSTANCE.entrance.getArrayList().loadOriginal();
		Lists.INSTANCE.entrance.getArrayList().shuffle();

		for (Guest guest : Lists.INSTANCE.entrance)
			guest.getImageView().setVisible(true);

		for (int counter = 1; counter <= 26; counter++)
			Lists.INSTANCE.entrance.getArrayList().removeRandom();

		Lists.INSTANCE.entrance.relocateImageViews();

	}

}
