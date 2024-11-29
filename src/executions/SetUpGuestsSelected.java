package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import model.Room;
import model.Rooms;
import utils.ArrayList;

public enum SetUpGuestsSelected {

	INSTANCE;

	private ArrayList<Guest> bistro = new ArrayList<>();
	private ArrayList<Guest> rooms = new ArrayList<>();
	private ArrayList<Guest> annex = new ArrayList<>();
	private ArrayList<Guest> hand = new ArrayList<>();

	public void execute() {

		clearLists();

		setUpBistro();
		setUpRooms();
		setUpAnnex();
		setUpHand();

	}

	public ArrayList<Guest> getBistro() {
		return this.bistro;
	}

	public ArrayList<Guest> getRooms() {
		return this.rooms;
	}

	public ArrayList<Guest> getAnnex() {
		return this.annex;
	}

	public ArrayList<Guest> getHand() {
		return this.hand;
	}

	private void setUpHand() {

		for (Guest guest : Lists.INSTANCE.hand)
			if (guest.isSelected())
				this.hand.addLast(guest);

	}

	private void setUpAnnex() {

		for (Card card : Lists.INSTANCE.annex) {

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;

			if (guest.isSelected())
				this.annex.addLast(guest);

		}

	}

	private void setUpRooms() {

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			if (room.getGuestList().getArrayList().getFirst().isSelected())
				this.rooms.addLast(room.getGuestList().getArrayList().getFirst());

		}

	}

	private void setUpBistro() {

		for (Guest guest : Lists.INSTANCE.bistro)
			if (guest.isSelected())
				this.bistro.addLast(guest);

	}

	private void clearLists() {

		this.bistro.clear();
		this.rooms.clear();
		this.annex.clear();
		this.hand.clear();

	}

}
