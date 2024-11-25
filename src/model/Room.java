package model;

import cards.Guest;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.Vector2;

public class Room {

	private ListImageViewAbles<Guest> list = new ListImageViewAbles<>();

	public Room(double x, double y) {

		createGuestList(x, y);

	}

	private void createGuestList(double x, double y) {

		ListCredentials listCredentials = this.list.getListCredentials();
		listCredentials.coordinatesList = new Vector2(x, y);
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list.getArrayList().setCapacity(1);

	}

}
