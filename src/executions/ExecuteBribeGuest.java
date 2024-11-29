package executions;

import cards.Guest;
import controller.Lists;
import enums.EGuest;
import enums.EGuestType;
import model.Rooms;
import utils.ListImageViewAbles;

public enum ExecuteBribeGuest {

	INSTANCE;

	public void execute() {

		removeCardsFromHand();
		addBribedCardToHand();

	}

	private void addBribedCardToHand() {

		Guest guest = null;

		if (!SetUpGuestsSelected.INSTANCE.getBistro().isEmpty()) {

			guest = SetUpGuestsSelected.INSTANCE.getBistro().removeFirst();
			Lists.INSTANCE.bistro.getArrayList().remove(guest);

		} else {

			guest = SetUpGuestsSelected.INSTANCE.getRooms().removeFirst();
			Rooms.INSTANCE.removeGuestFromRoom(guest);

		}

		Lists.INSTANCE.hand.getArrayList().addLast(guest);
		Lists.INSTANCE.hand.relocateImageViews();

	}

	private void removeCardsFromHand() {

		for (Guest guest : SetUpGuestsSelected.INSTANCE.getHand()) {

			if (guest.getGuestModel().getEGuestType().equals(EGuestType.MERCHANT))
				continue;

			Lists.INSTANCE.hand.getArrayList().remove(guest);

			ListImageViewAbles<Guest> list = null;

			if (guest.getGuestModel().getEGuest().equals(EGuest.PEASANT_MALE)
					|| guest.getGuestModel().getEGuest().equals(EGuest.PEASANT_FEMALE))
				list = Lists.INSTANCE.bistro;
			else
				list = Lists.INSTANCE.exit;

			list.getArrayList().addFirst(guest);
			list.relocateImageViews();

		}

		Lists.INSTANCE.hand.relocateImageViews();

	}

}
