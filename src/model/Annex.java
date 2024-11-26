package model;

import cards.Guest;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.Vector2;

public class Annex {

	private ListImageViewAbles<Guest> annex = new ListImageViewAbles<>();

	public Annex(double x, double y) {

		createGuestList(x, y);

	}

	private void createGuestList(double x, double y) {

		ListCredentials listCredentials = this.annex.getListCredentials();
		listCredentials.coordinatesList = new Vector2(x, y);
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.annex.getArrayList().setCapacity(1);

	}

	public ListImageViewAbles<Guest> getAnnexList() {
		return this.annex;
	}

}
