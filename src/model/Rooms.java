package model;

import cards.Guest;
import controller.Credentials;
import utils.ArrayList;
import utils.ShutDown;

public enum Rooms {

	INSTANCE;

	private ArrayList<Room> rooms = new ArrayList<>();

	private Rooms() {

		createRooms();

	}

	public void removeGuestFromRoom(Guest guest) {

		boolean success = false;

		for (Room room : this.rooms) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			if (!room.getGuestList().getArrayList().contains(guest))
				continue;

			room.getGuestList().getArrayList().remove(guest);
			success = true;

		}

		if (!success)
			ShutDown.INSTANCE.execute();

	}

	public ArrayList<Room> getRooms() {
		return this.rooms;
	}

	private void createRooms() {

		double x = Credentials.INSTANCE.cRooms.x;
		double y = Credentials.INSTANCE.cRooms.y;

		for (int counter = 1; counter <= 4; counter++) {

			this.rooms.addLast(new Room(x, y));
			x += Credentials.INSTANCE.dCardAndGapBetweenComponents.x;

		}

	}

}
