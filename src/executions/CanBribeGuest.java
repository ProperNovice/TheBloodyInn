package executions;

import cards.Guest;
import controller.Lists;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.SelectImageViewManager;

public enum CanBribeGuest {

	INSTANCE;

	private ArrayList<Guest> peasantSelected = new ArrayList<>();
	private ArrayList<Guest> guestsSelectedInTotal = new ArrayList<>();
	private ArrayList<Guest> guestsRoomsSelected = new ArrayList<>();
	private ArrayList<Guest> guestsHandSelected = new ArrayList<>();

	public boolean execute() {

		setupGuestsSelectedInTotal();
		peasantIsSelected();
		guestsHandSelected();
		guestsRoomsSelected();

		if (this.peasantSelected.size() + this.guestsRoomsSelected.size() != 1)
			return false;

		Guest guestSelected = null;

		if (!peasantSelected.isEmpty())
			guestSelected = this.peasantSelected.getFirst();
		else
			guestSelected = this.guestsRoomsSelected.getFirst();

		int rankGuestSelected = guestSelected.getGuestModel().getRank();

		return rankGuestSelected == this.guestsHandSelected.size();

	}

	private void setupGuestsSelectedInTotal() {

		this.guestsSelectedInTotal.clear();

		for (IImageViewAble imageViewAble : SelectImageViewManager.INSTANCE
				.getSelectedImageViewAbles()) {

			Guest guest = (Guest) imageViewAble;
			this.guestsSelectedInTotal.addLast(guest);

		}

	}

	private void peasantIsSelected() {

		this.peasantSelected.clear();

		Guest peasant = Lists.INSTANCE.bistro.getArrayList().getFirst();

		if (!this.guestsSelectedInTotal.contains(peasant))
			return;

		this.guestsSelectedInTotal.remove(peasant);
		this.peasantSelected.addLast(peasant);

	}

	private void guestsHandSelected() {

		this.guestsHandSelected.clear();

		for (Guest guest : this.guestsSelectedInTotal.clone()) {

			if (!Lists.INSTANCE.hand.getArrayList().contains(guest))
				continue;

			this.guestsSelectedInTotal.remove(guest);
			this.guestsHandSelected.addLast(guest);

		}

	}

	private void guestsRoomsSelected() {
		this.guestsRoomsSelected = this.guestsSelectedInTotal.clone();
	}

}
