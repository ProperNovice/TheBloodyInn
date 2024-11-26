package model;

import cards.Guest;
import tokens.Token;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.Vector2;

public class Room {

	private ListImageViewAbles<Guest> guest = new ListImageViewAbles<>();
	private ListImageViewAbles<Token> tokens = new ListImageViewAbles<>();

	public Room(double x, double y) {

		createGuestList(x, y);
		createTokenList(x, y);

	}

	private void createTokenList(double x, double y) {

		ListCredentials listCredentials = this.tokens.getListCredentials();
		listCredentials.coordinatesList = new Vector2(x, y);
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.PIVOT;

	}

	private void createGuestList(double x, double y) {

		ListCredentials listCredentials = this.guest.getListCredentials();
		listCredentials.coordinatesList = new Vector2(x, y);
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.guest.getArrayList().setCapacity(1);

	}

	public ListImageViewAbles<Guest> getGuestList() {
		return this.guest;
	}

	public ListImageViewAbles<Token> getTokensList() {
		return this.tokens;
	}

}
