package model;

import controller.Credentials;
import utils.ArrayList;

public enum Rooms {

	INSTANCE;

	private ArrayList<Room> rooms = new ArrayList<>();

	private Rooms() {

		createRooms();

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
