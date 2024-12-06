package gameStates;

import cards.PlayerAid;
import controller.Lists;
import enums.EColor;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;
import model.TokenManager;
import tokens.KeyToken;
import tokens.KeyTokenNeutral;
import utils.ArrayList;
import utils.ObjectPool;

public class SetUpGame extends GameState {

	@Override
	public void execute() {

		addStartingKeys();
		addPlayerAid();
		proceedToNextGameState();

	}

	private void addPlayerAid() {

		Lists.INSTANCE.annex.getArrayList().addFirst(new PlayerAid());
		Lists.INSTANCE.annex.getArrayList().saveOriginal();

		Lists.INSTANCE.annex.relocateImageViews();

	}

	private void addStartingKeys() {

		// first room

		Room room = Rooms.INSTANCE.getRooms().getFirst();

		EColor eColor = null;

		do {
			eColor = new ArrayList<>(EColor.values()).removeRandom();
		} while (eColor == EColor.NEUTRAL);

		KeyToken keyToken = TokenManager.INSTANCE.getKeyToken(eColor);

		room.getTokensList().getArrayList().addLast(keyToken);
		room.getTokensList().getArrayList().saveOriginal();

		room.getTokensList().relocateImageViews();

		// subsequent room

		for (Room roomTemp : Rooms.INSTANCE.getRooms()) {

			if (roomTemp.equals(Rooms.INSTANCE.getRooms().getFirst()))
				continue;

			KeyToken keyTokenNeutral = ObjectPool.INSTANCE.acquire(KeyTokenNeutral.class);
			roomTemp.getTokensList().getArrayList().addLast(keyTokenNeutral);
			roomTemp.getTokensList().relocateImageViews();

			roomTemp.getTokensList().getArrayList().saveOriginal();

		}

	}

}
