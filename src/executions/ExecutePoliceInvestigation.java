package executions;

import cards.Guest;
import enums.EGuestType;
import gameStatesDefault.EndGameLost;
import model.Room;
import model.Rooms;
import utils.Flow;

public enum ExecutePoliceInvestigation {

	INSTANCE;

	public void execute() {

		if (GetCorpsesToBury.INSTANCE.execute().isEmpty())
			return;

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();
			EGuestType eGuestType = guest.getGuestModel().getEGuestType();

			if (!eGuestType.equals(EGuestType.POLICE))
				continue;

			Flow.INSTANCE.getFlow().addFirst(EndGameLost.class);

			return;

		}

	}

}
