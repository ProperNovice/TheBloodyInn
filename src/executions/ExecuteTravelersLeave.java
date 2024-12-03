package executions;

import model.Room;
import model.Rooms;
import model.Statistics;
import tokens.KeyToken;
import tokens.KeyTokenNeutral;
import tokens.Token;

public enum ExecuteTravelersLeave {

	INSTANCE;

	public void execute() {

		int cash = 0;

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			for (Token token : room.getTokensList()) {

				if (!(token instanceof KeyToken))
					continue;

				KeyToken keyToken = (KeyToken) token;

				if (keyToken instanceof KeyTokenNeutral)
					continue;

				cash++;

			}

		}

		Statistics.INSTANCE.addCash(cash);

	}

}
