package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EText;
import executions.AddPeasantFromBistroToHand;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;
import states.DeckRun;
import states.Statistics;
import tokens.Token;
import utils.Enums.ListsSaveLoad;

public class StartGame extends GameState {

	@Override
	public void execute() {

		EText.START_GAME.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		handleRoomTokens(false);
		ListsSaveLoad.INSTANCE.loadListsOriginal();
		handleRoomTokens(true);

		prepareGuests();
		preparePeasants();

		Statistics.INSTANCE.resetIndicators();
		DeckRun.INSTANCE.setFirst();

		flow().addFirst(StartNewTurn.class);
		proceedToNextGameState();

	}

	private void preparePeasants() {

		Lists.INSTANCE.bistro.getArrayList().loadOriginal();
		Lists.INSTANCE.bistro.getArrayList().shuffle();

		for (Guest guest : Lists.INSTANCE.bistro) {

			guest.getImageView().flipFront();
			guest.getImageView().setVisible(true);

		}

		Lists.INSTANCE.bistro.relocateImageViews();

		AddPeasantFromBistroToHand.INSTANCE.execute(2);

	}

	private void prepareGuests() {

		Lists.INSTANCE.entrance.getArrayList().loadOriginal();
		Lists.INSTANCE.entrance.getArrayList().shuffle();
		Lists.INSTANCE.entrance.relocateImageViews();

		for (Guest guest : Lists.INSTANCE.entrance) {

			guest.getImageView().flipFront();
			guest.getImageView().setVisible(true);

		}

		for (int counter = 1; counter <= 26; counter++)
			Lists.INSTANCE.entrance.getArrayList().removeRandom();

		Lists.INSTANCE.entrance.relocateImageViews();

	}

	private void handleRoomTokens(boolean value) {

		for (Room room : Rooms.INSTANCE.getRooms()) {

			for (Token token : room.getTokensList())
				token.getImageView().setVisible(value);

			room.getTokensList().relocateImageViews();

		}

	}

}
