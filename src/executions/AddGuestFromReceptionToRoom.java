package executions;

import cards.Guest;
import controller.Lists;
import model.Room;
import states.Statistics;

public enum AddGuestFromReceptionToRoom {

	INSTANCE;

	public void execute(Room room) {

		Guest guest = Lists.INSTANCE.reception.getArrayList().removeFirst();
		room.getGuestList().getArrayList().addLast(guest);
		room.getGuestList().relocateImageViews();

		if (room.getTokensList().getArrayList().size() == 1)
			return;

		int rank = guest.getGuestModel().getRank();
		Statistics.INSTANCE.addCash(rank);

	}

}
