package controller;

import cards.Card;
import cards.Guest;
import utils.Enums.RearrangeTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum Lists {

	INSTANCE;

	public ListImageViewAbles<Guest> entrance = new ListImageViewAbles<>();
	public ListImageViewAbles<Guest> reception = new ListImageViewAbles<>();
	public ListImageViewAbles<Guest> bistro = new ListImageViewAbles<>();
	public ListImageViewAbles<Guest> exit = new ListImageViewAbles<>();
	public ListImageViewAbles<Guest> hand = new ListImageViewAbles<>();
	public ListImageViewAbles<Card> annex = new ListImageViewAbles<>();

	private Lists() {

		ListCredentials listCredentials = null;

		// entrance

		listCredentials = this.entrance.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cEntrance;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.showListSize = true;

		// reception

		listCredentials = this.reception.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cReception;

		// bistro

		listCredentials = this.bistro.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cBistro;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.showListSize = true;

		// exit

		listCredentials = this.exit.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cExit;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;

		// annex

		listCredentials = this.annex.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cAnnex;

		// hand

		listCredentials = this.hand.getListCredentials();
		listCredentials.coordinatesList = Credentials.INSTANCE.cHand;

	}

}
