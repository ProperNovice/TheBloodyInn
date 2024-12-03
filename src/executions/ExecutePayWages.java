package executions;

import controller.Lists;
import model.Statistics;
import states.WagesNeedToBePaid;

public enum ExecutePayWages {

	INSTANCE;

	public void execute() {

		int cashToPay = Lists.INSTANCE.hand.getArrayList().size();
		int cashAvailable = Statistics.INSTANCE.getCash();

		int cashPaid = Math.min(cashToPay, cashAvailable);

		Statistics.INSTANCE.removeCash(cashPaid);

		int wagesNeedToBePaid = cashToPay - cashPaid;
		WagesNeedToBePaid.INSTANCE.set(wagesNeedToBePaid);

	}

}
