package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EGuest;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;
import model.Room;
import model.Rooms;

public class JUnit extends GameState {

	@Override
	public void execute() {

		addGuestToRoom(EGuest.BISHOP);
		addGuestToRoom(EGuest.COUNT);
		addGuestToRoom(EGuest.MONK);
		addGuestToRoom(EGuest.NEWSBOY);

		addGuestToAnnex(EGuest.BISHOP);
		addGuestToAnnex(EGuest.COUNT);
		addGuestToAnnex(EGuest.MONK);
		addGuestToAnnex(EGuest.CONCIERGE);

		addGuestToHand(EGuest.BISHOP);
		addGuestToHand(EGuest.COUNT);
		addGuestToHand(EGuest.MONK);
		addGuestToHand(EGuest.CONCIERGE);
		addGuestToHand(EGuest.PEASANT_MALE);

		flow().addLast(SetUpGame.class);
//		flow().addLast(Evening.class);
//		flow().addLast(Night.class);

		flow().addLast(BribeGuest.class);

		Lists.INSTANCE.entrance.getArrayList().shuffle();
		Lists.INSTANCE.entrance.relocateImageViews();

		proceedToNextGameState();

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

	}

	public void addGuestToRoom(EGuest eGuest) {

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (!room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = new Guest(eGuest);
			room.getGuestList().getArrayList().addLast(guest);
			room.getGuestList().relocateImageViews();

			break;

		}

	}

	public void addGuestToAnnex(EGuest eGuest) {

		Lists.INSTANCE.annex.getArrayList().addLast(new Guest(eGuest));
		Lists.INSTANCE.annex.relocateImageViews();

	}

	public void addGuestToHand(EGuest eGuest) {

		Lists.INSTANCE.hand.getArrayList().addLast(new Guest(eGuest));
		Lists.INSTANCE.hand.relocateImageViews();

	}

}
