package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EGuest;
import enums.EGuestType;
import enums.EText;
import executions.AddGuestFromRoomToHand;
import executions.AddPeasantFromBistroToHand;
import executions.AnnexContainGuest;
import executions.GetGuestsCanBeBribed;
import gameStatesDefault.GameState;
import model.Room;
import states.PeasantsCanBeBribed;

public class BribeGuest extends GameState {

	@Override
	public void execute() {

		EText.CHOOSE_GUEST_TO_BRIBE.show();

		for (Guest guest : GetGuestsCanBeBribed.INSTANCE.execute())
			guest.setSelected();

	}

	@Override
	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel, Room room) {

		if (!guest.isSelected())
			return;

		AddGuestFromRoomToHand.INSTANCE.execute(guest, room);
		proceed(guestModel.getEGuestType());

	}

	@Override
	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {

		if (!guest.isSelected())
			return;

		AddPeasantFromBistroToHand.INSTANCE.execute(1);

		proceed(guestModel.getEGuestType());

	}

	private void proceed(EGuestType eGuestType) {

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();

		if (eGuestType.equals(EGuestType.PEASANT)) {

			if (AnnexContainGuest.INSTANCE.execute(EGuest.BREWER) > 0)
				PeasantsCanBeBribed.INSTANCE.reset(4);
			else
				PeasantsCanBeBribed.INSTANCE.reset(2);

			PeasantsCanBeBribed.INSTANCE.reducePeasantBribed();
			flow().addFirst(BribeExtraPeasant.class);

		} else
			flow().addFirst(DiscardCardsForBribingGuest.class);

		proceedToNextGameState();

	}

}
