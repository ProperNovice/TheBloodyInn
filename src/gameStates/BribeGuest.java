package gameStates;

import cards.Guest;
import cards.GuestModel;
import controller.Lists;
import enums.EGuestType;
import enums.EText;
import executions.CanExecuteBribeGuest;
import executions.ExecuteBribeGuest;
import gameStatesDefault.GameState;
import states.PeasantsCanBeBribed;

public class BribeGuest extends GameState {

	@Override
	public void execute() {

		concealText();
		EText.BRIBE_GUEST_INDICATOR.show();
		EText.CONTINUE_INDICATOR.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		getSelectImageViewManager().releaseSelectImageViews();
		ExecuteBribeGuest.INSTANCE.execute();

		Guest guest = Lists.INSTANCE.hand.getArrayList().getLast();
		EGuestType eGuestType = guest.getGuestModel().getEGuestType();

		if (eGuestType.equals(EGuestType.PEASANT)) {

			if (!Lists.INSTANCE.bistro.getArrayList().isEmpty()) {

				PeasantsCanBeBribed.INSTANCE.reset(2);
				PeasantsCanBeBribed.INSTANCE.reducePeasantBribed();

				flow().addFirst(BribePeasant.class);

			}

		}

		proceedToNextGameState();

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

		if (CanExecuteBribeGuest.INSTANCE.execute())
			EText.CONTINUE_OPTION.show();
		else
			EText.CONTINUE_INDICATOR.show();

	}

}
