package executions;

import enums.EColor;
import model.Room;
import model.Rooms;
import model.TokenManager;
import tokens.RoomServiceToken;

public enum ExecutePlaceServiceToken {

	INSTANCE;

	public void execute(Room room) {

		EColor eColor = Rooms.INSTANCE.getRooms().getFirst().getTokensList().getArrayList()
				.getFirst().getEColor();

		RoomServiceToken roomServiceToken = TokenManager.INSTANCE.getRoomServiceToken(eColor);
		room.getTokensList().getArrayList().addLast(roomServiceToken);
		room.getTokensList().relocateImageViews();

	}

}
