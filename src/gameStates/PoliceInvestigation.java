package gameStates;

import cards.Guest;
import enums.EGuestType;
import enums.EText;
import executions.ExecutePoliceInvestigation;
import gameStatesDefault.GameState;
import model.Room;
import model.Rooms;

public class PoliceInvestigation extends GameState {

	@Override
	public void execute() {

		boolean policeFound = false;

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();
			EGuestType eGuestType = guest.getGuestModel().getEGuestType();

			if (eGuestType.equals(EGuestType.POLICE))
				policeFound = true;

		}

		if (!policeFound) {

			proceedToNextGameState();
			return;

		}

		EText.POLICE_INVESTIGATION.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ExecutePoliceInvestigation.INSTANCE.execute();
		proceedToNextGameState();

	}

}
