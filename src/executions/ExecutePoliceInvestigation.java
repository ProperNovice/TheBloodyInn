package executions;

import cards.Card;
import cards.Guest;
import controller.Lists;
import gameStatesDefault.EndGameLost;
import utils.Flow;

public enum ExecutePoliceInvestigation {

	INSTANCE;

	public void execute() {

		boolean corpseFound = false;

		for (Card card : Lists.INSTANCE.annex) {

			if (!(card instanceof Guest))
				continue;

			Guest guest = (Guest) card;

			if (guest.getImageView().isFlippedFront())
				continue;

			corpseFound = true;

		}

		if (!corpseFound)
			return;

		Flow.INSTANCE.getFlow().addFirst(EndGameLost.class);

	}

}
