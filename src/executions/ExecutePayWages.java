package executions;

import controller.Lists;
import enums.EGuest;
import states.Statistics;
import states.WagesNeedToBePaid;

public enum ExecutePayWages {

	INSTANCE;

	public void execute() {

		int cashToPay = Lists.INSTANCE.hand.getArrayList().size();
		cashToPay -= AnnexContainGuest.INSTANCE.execute(EGuest.DISTILLER);

		int cashAvailable = Statistics.INSTANCE.getCash();

		int cashPaid = Math.min(cashToPay, cashAvailable);

		Statistics.INSTANCE.removeCash(cashPaid);

		int wagesNeedToBePaid = cashToPay - cashPaid;
		WagesNeedToBePaid.INSTANCE.set(wagesNeedToBePaid);

	}

}
