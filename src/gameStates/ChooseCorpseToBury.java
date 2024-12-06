package gameStates;

import cards.Guest;
import cards.GuestModel;
import enums.EText;
import executions.ExecuteBuryCorpse;
import executions.GetCorpsesToBury;
import gameStatesDefault.GameState;

public class ChooseCorpseToBury extends GameState {

	@Override
	public void execute() {

		for (Guest guest : GetCorpsesToBury.INSTANCE.execute())
			guest.setSelected();

		if (GetCorpsesToBury.INSTANCE.execute().size() == 1)
			executeBuryCorpse(GetCorpsesToBury.INSTANCE.execute().getFirst());
		else
			EText.CHOOSE_CORPSE_TO_BURY.show();

	}

	@Override
	protected void handleGuestPressedAnnex(Guest guest, GuestModel guestModel) {

		if (!guest.isSelected())
			return;

		executeBuryCorpse(guest);

	}

	private void executeBuryCorpse(Guest guest) {

		concealText();
		getSelectImageViewManager().releaseSelectImageViews();
		ExecuteBuryCorpse.INSTANCE.execute(guest, guest.getGuestModel());
		proceedToNextGameState();

	}

}
