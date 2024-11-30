package cards;

import enums.EGuest;
import enums.EGuestType;
import utils.Logger;

public class GuestModel {

	private EGuest eGuest = null;
	private EGuestType eGuestType = null;
	private int rank = -1, pocketMoney = -1;
	private boolean canBuildAnnex;

	public GuestModel(EGuest eGuest) {

		this.eGuest = eGuest;
		this.eGuestType = this.eGuest.getEGuestType();
		this.rank = this.eGuest.getRank();
		this.canBuildAnnex = this.eGuestType.canBuildAnnex();

		createPocketMoney();

	}

	public void print() {

		Logger.INSTANCE.logNewLine("*");
		Logger.INSTANCE.logNewLine("printing guest");
		Logger.INSTANCE.log("guest -> " + this.eGuest.toString().toLowerCase());
		Logger.INSTANCE.log("type -> " + this.eGuestType.toString().toLowerCase());
		Logger.INSTANCE.log("rank -> " + this.rank);
		Logger.INSTANCE.log("pocket money -> " + this.pocketMoney);
		Logger.INSTANCE.newLine();
		Logger.INSTANCE.log("*");
		Logger.INSTANCE.newLine();

	}

	private void createPocketMoney() {

		if (this.eGuestType.equals(EGuestType.PEASANT)) {

			this.pocketMoney = 4;
			return;

		}

		switch (this.rank) {

		case 0:
			this.pocketMoney = 8;
			break;

		case 1:
			this.pocketMoney = 12;
			break;

		case 2:
			this.pocketMoney = 18;
			break;

		case 3:
			this.pocketMoney = 26;
			break;

		}

	}

	public EGuest getEGuest() {
		return this.eGuest;
	}

	public EGuestType getEGuestType() {
		return this.eGuestType;
	}

	public int getRank() {
		return this.rank;
	}

	public int getPocketMoney() {
		return this.pocketMoney;
	}

	public boolean canBuildAnnex() {
		return this.canBuildAnnex;
	}

}
