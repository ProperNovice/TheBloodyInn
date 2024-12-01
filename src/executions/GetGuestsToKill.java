package executions;

import cards.Guest;
import controller.Lists;
import model.Room;
import model.Rooms;
import utils.ArrayList;

public enum GetGuestsToKill {

	INSTANCE;

	public ArrayList<Guest> execute() {

		ArrayList<Guest> list = new ArrayList<>();

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();

			int guestRank = guest.getGuestModel().getRank();

			if (Lists.INSTANCE.hand.getArrayList().size() < guestRank)
				continue;

			list.addLast(guest);

		}

		return list;

	}

}
