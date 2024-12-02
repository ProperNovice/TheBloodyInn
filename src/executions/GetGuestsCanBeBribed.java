package executions;

import cards.Guest;
import controller.Lists;
import model.Room;
import model.Rooms;
import utils.ArrayList;

public enum GetGuestsCanBeBribed {

	INSTANCE;

	public ArrayList<Guest> execute() {

		ArrayList<Guest> list = new ArrayList<>();

		if (!Lists.INSTANCE.bistro.getArrayList().isEmpty())
			list.addFirst(Lists.INSTANCE.bistro.getArrayList().getFirst());

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();
			int guestRank = guest.getGuestModel().getRank();

			if (guestRank > Lists.INSTANCE.hand.getArrayList().size())
				continue;

			list.addLast(guest);

		}

		return list;

	}

}
