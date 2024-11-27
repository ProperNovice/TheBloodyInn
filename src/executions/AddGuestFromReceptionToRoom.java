package executions;

import cards.Guest;
import controller.Lists;
import model.Room;

public enum AddGuestFromReceptionToRoom {

	INSTANCE;

	public void execute(Room room) {

		Guest guest = Lists.INSTANCE.reception.getArrayList().removeFirst();
		room.getGuestList().getArrayList().addLast(guest);
		room.getGuestList().relocateImageViews();

	}

}
