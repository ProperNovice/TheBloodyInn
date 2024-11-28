package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EText;
import executions.CanBribeGuest;
import gameStatesDefault.GameState;

public class BribeGuest extends GameState {

	@Override
	public void execute() {

		concealText();
		EText.BRIBE_GUEST_INDICATOR.show();
		EText.CONTINUE_INDICATOR.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

	}

	@Override
	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel) {
		executeGuestPressed(guest);
	}

	@Override
	protected void handleGuestPressedHand(Guest guest, GuestModel guestModel) {
		executeGuestPressed(guest);
	}

	@Override
	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {
		executeGuestPressed(guest);
	}

	private void executeGuestPressed(Guest guest) {

		guest.reverseSelected();

		concealText();
		EText.BRIBE_GUEST_INDICATOR.show();

		if (CanBribeGuest.INSTANCE.execute())
			EText.CONTINUE_OPTION.show();
		else
			EText.CONTINUE_INDICATOR.show();

	}

}
