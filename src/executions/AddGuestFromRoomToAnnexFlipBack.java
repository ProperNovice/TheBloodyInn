package executions;

import cards.Guest;
import controller.Lists;
import model.Room;

public enum AddGuestFromRoomToAnnexFlipBack {

	INSTANCE;

	public void execute(Guest guest, Room room) {

		room.getGuestList().getArrayList().removeFirst();
		Lists.INSTANCE.annex.getArrayList().addLast(guest);
		guest.getImageView().flipBack();

		Lists.INSTANCE.annex.relocateImageViews();

	}

}
