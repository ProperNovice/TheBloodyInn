package executions;

import states.Statistics;

public enum Launder {

	INSTANCE;

	public void execute() {

		Statistics.INSTANCE.removeCash(10);
		Statistics.INSTANCE.addChecks(1);

	}

}
