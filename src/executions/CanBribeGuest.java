package executions;

import cards.Guest;
import controller.Lists;
import model.Room;
import model.Rooms;
import utils.ArrayList;

public enum CanBribeGuest {

	INSTANCE;

	private ArrayList<Guest> guestsRoomsBistroSelected = new ArrayList<>();
	private ArrayList<Guest> guestsHandSelected = new ArrayList<>();

	public boolean execute() {

		this.guestsRoomsBistroSelected.clear();
		this.guestsHandSelected.clear();

		guestsBistroHandSelected();
		guestsRoomsSelected();

		if (this.guestsRoomsBistroSelected.size() != 1)
			return false;

		Guest guestSelected = this.guestsRoomsBistroSelected.getFirst();
		int rankGuestSelected = guestSelected.getGuestModel().getRank();

		return rankGuestSelected == this.guestsHandSelected.size();

	}

	private void guestsBistroHandSelected() {

		setSelected(this.guestsRoomsBistroSelected, Lists.INSTANCE.bistro.getArrayList());
		setSelected(this.guestsHandSelected, Lists.INSTANCE.hand.getArrayList());

	}

	private void guestsRoomsSelected() {

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();

			if (guest.isSelected())
				this.guestsRoomsBistroSelected.addLast(guest);

		}

	}

	private void setSelected(ArrayList<Guest> tempList, ArrayList<Guest> originalList) {

		for (Guest guest : originalList)
			if (guest.isSelected())
				tempList.addLast(guest);

	}

}
