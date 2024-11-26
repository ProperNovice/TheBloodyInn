package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EColor;
import enums.EText;
import executions.AddPeasantFromBistroToHand;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;
import tokens.KeyToken;
import tokens.KeyTokenBlue;
import tokens.KeyTokenGreen;
import tokens.KeyTokenNeutral;
import tokens.KeyTokenRed;
import tokens.KeyTokenYellow;
import utils.ArrayList;
import utils.ObjectPool;

public class StartGame extends GameState {

	@Override
	public void execute() {

		EText.START_GAME.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		prepareGuests();
		addStartingKeys();
		addPeasants();

	}

	private void addPeasants() {
		AddPeasantFromBistroToHand.INSTANCE.execute(2);
	}

	private void addStartingKeys() {

		// first room

		Room room = Rooms.INSTANCE.getRooms().getFirst();

		EColor eColor = null;

		do {
			eColor = new ArrayList<>(EColor.values()).removeRandom();
		} while (eColor == EColor.NEUTRAL);

		Class<? extends KeyToken> keyTokenClass = null;

		switch (eColor) {

		case BLUE:
			keyTokenClass = KeyTokenBlue.class;
			break;

		case GREEN:
			keyTokenClass = KeyTokenGreen.class;
			break;

		case RED:
			keyTokenClass = KeyTokenRed.class;
			break;

		case YELLOW:
			keyTokenClass = KeyTokenYellow.class;
			break;

		default:
			break;

		}

		KeyToken keyToken = ObjectPool.INSTANCE.acquire(keyTokenClass);

		room.getTokensList().getArrayList().addLast(keyToken);
		room.getTokensList().relocateImageViews();

		// subsequent room

		for (Room roomTemp : Rooms.INSTANCE.getRooms()) {

			if (roomTemp.equals(Rooms.INSTANCE.getRooms().getFirst()))
				continue;

			KeyToken keyTokenNeutral = ObjectPool.INSTANCE.acquire(KeyTokenNeutral.class);
			roomTemp.getTokensList().getArrayList().addLast(keyTokenNeutral);
			roomTemp.getTokensList().relocateImageViews();

		}

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
