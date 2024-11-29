package executions;

import cards.Guest;

public enum CanBribeGuest {

	INSTANCE;

	public boolean execute() {

		SetUpGuestsSelected.INSTANCE.execute();

		// check if more than one target is selected

		if (SetUpGuestsSelected.INSTANCE.getBistro().size()
				+ SetUpGuestsSelected.INSTANCE.getRooms().size() != 1)
			return false;

		// count how many from hand are selected

		int guestsSelectedCount = SetUpGuestsSelected.INSTANCE.getHand().size();

		// set up guest selected

		Guest guestSelected = null;

		if (!SetUpGuestsSelected.INSTANCE.getBistro().isEmpty())
			guestSelected = SetUpGuestsSelected.INSTANCE.getBistro().getFirst();
		else if (!SetUpGuestsSelected.INSTANCE.getRooms().isEmpty())
			guestSelected = SetUpGuestsSelected.INSTANCE.getRooms().getFirst();

		// check rank

		int rankGuestSelected = guestSelected.getGuestModel().getRank();

		return rankGuestSelected == guestsSelectedCount;

	}

}
