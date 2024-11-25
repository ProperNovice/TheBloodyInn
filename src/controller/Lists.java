package controller;

import cards.Guest;
import utils.Enums.RearrangeTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum Lists {

	INSTANCE;

	public ListImageViewAbles<Guest> entrance = new ListImageViewAbles<>();
	public ListImageViewAbles<Guest> bistro = new ListImageViewAbles<>();
	public ListImageViewAbles<Guest> exit = new ListImageViewAbles<>();

	private Lists() {

		ListCredentials listCredentials = null;

		// entrance

		listCredentials = this.entrance.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cEntrance;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.showListSize = true;

		// bistro

		listCredentials = this.bistro.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cBistro;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.showListSize = true;

		// exit

		listCredentials = this.exit.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cExit;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;

	}

}
