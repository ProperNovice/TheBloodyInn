package gameStates;

import cards.Guest;
import controller.Lists;
import enums.EGuest;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;
import model.Room;
import model.Rooms;
import model.Statistics;

public class JUnit extends GameState {

	@Override
	public void execute() {

		addGuestToRoom(EGuest.BISHOP);
		addGuestToRoom(EGuest.COUNT);
		addGuestToRoom(EGuest.MONK);
		addGuestToRoom(EGuest.NEWSBOY);

		addGuestToAnnexAlive(EGuest.BISHOP);
		addGuestToAnnexAlive(EGuest.COUNT);
		addGuestToAnnexDead(EGuest.CONCIERGE);
		addGuestToAnnexAlive(EGuest.MONK);
		addGuestToAnnexAlive(EGuest.CONCIERGE);
		addGuestToAnnexDead(EGuest.BISHOP);

		addGuestToHand(EGuest.BRIGADIER);
		addGuestToHand(EGuest.CONCIERGE);
		addGuestToHand(EGuest.BISHOP);
		addGuestToHand(EGuest.PEASANT_MALE);
//		addGuestToHand(EGuest.GARDENER);
		addGuestToHand(EGuest.BREWER);
//		addGuestToHand(EGuest.BARON);
		addGuestToHand(EGuest.MONK);

		flow().addLast(SetUpGame.class);
//		flow().addLast(Evening.class);
//		flow().addLast(Night.class);

//		flow().addLast(BribeGuest.class);
		flow().addLast(ChooseActionOne.class);
//		flow().addLast(BuryCorpse.class);
//		flow().addLast(BuildAnnex.class);
//		flow().addLast(KillGuest.class);
//		flow().addLast(BribePeasant.class);
//		flow().addLast(DiscardCardsForBuildingAnnex.class);

		Lists.INSTANCE.entrance.getArrayList().shuffle();
		Lists.INSTANCE.entrance.relocateImageViews();

		Statistics.INSTANCE.addCash(30);
//		Statistics.INSTANCE.reduceAnnexAvailable();

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

	public void addGuestToAnnexAlive(EGuest eGuest) {

		Lists.INSTANCE.annex.getArrayList().addLast(new Guest(eGuest));
		Lists.INSTANCE.annex.relocateImageViews();

	}

	public void addGuestToAnnexDead(EGuest eGuest) {

		Lists.INSTANCE.annex.getArrayList().addLast(new Guest(eGuest));
		Lists.INSTANCE.annex.getArrayList().getLast().getImageView().flipBack();
		Lists.INSTANCE.annex.relocateImageViews();

	}

	public void addGuestToHand(EGuest eGuest) {

		Lists.INSTANCE.hand.getArrayList().addLast(new Guest(eGuest));
		Lists.INSTANCE.hand.relocateImageViews();

	}

}
