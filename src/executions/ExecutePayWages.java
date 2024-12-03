package executions;

import controller.Lists;
import model.Statistics;

public enum ExecutePayWages {

	INSTANCE;

	public void execute() {

		int cashToPay = Lists.INSTANCE.hand.getArrayList().size();
		int cashAvailable = Statistics.INSTANCE.getCash();

		int cashToExecute = Math.min(cashToPay, cashAvailable);
		
		Statistics.INSTANCE.removeCash(cashToExecute);

	}

}
