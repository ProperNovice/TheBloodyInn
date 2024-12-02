package executions;

import cards.Guest;
import controller.Lists;
import model.Room;

public enum AddGuestFromRoomToHand {

	INSTANCE;

	public void execute(Guest guest, Room room) {

		room.getGuestList().getArrayList().removeFirst();
		Lists.INSTANCE.hand.getArrayList().addLast(guest);
		Lists.INSTANCE.hand.relocateImageViews();

	}

}
