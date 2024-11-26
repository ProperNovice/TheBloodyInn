package model;

import controller.Credentials;
import utils.ArrayList;

public enum Annexes {

	INSTANCE;

	private ArrayList<Annex> annexes = new ArrayList<>();

	private Annexes() {

		createAnnexes();

	}

	public ArrayList<Annex> getAnnexes() {
		return this.annexes;
	}

	private void createAnnexes() {

		double x = Credentials.INSTANCE.cRooms.x;
		double y = Credentials.INSTANCE.cRooms.y;

		for (int counter = 1; counter <= 114; counter++) {

			this.annexes.addLast(new Annex(x, y));
			x += Credentials.INSTANCE.dCardAndGapBetweenComponents.x;

		}

	}

}
