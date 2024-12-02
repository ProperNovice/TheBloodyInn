package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EText;
import gameStatesDefault.GameState;
import model.Room;

public class ChooseGuestToBribe extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_GUEST_TO_BRIBE.show();

	}

	@Override
	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel, Room room) {

		if (!guest.isSelected())
			return;

	}

	@Override
	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {

		if (!guest.isSelected())
			return;

	}

}
