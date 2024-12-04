package executions;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import states.CorpseBuried;
import states.Statistics;

public enum ExecuteBuryCorpse {

	INSTANCE;

	public void execute(Guest guest, GuestModel guestModel) {

		Lists.INSTANCE.annex.getArrayList().remove(guest);
		guest.getImageView().setVisible(false);
		Lists.INSTANCE.annex.relocateImageViews();
		CorpseBuried.INSTANCE.set(guest);

		int pocketMoney = guestModel.getPocketMoney();
		Statistics.INSTANCE.addCash(pocketMoney);
		Statistics.INSTANCE.reduceAnnex();

	}

}
