package executions;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import model.Statistics;
import states.CorpseBuried;

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
