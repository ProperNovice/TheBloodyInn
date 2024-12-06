package executions;

import enums.EColor;
import model.Room;
import model.Rooms;
import model.TokenManager;
import tokens.KeyToken;
import tokens.Token;
import utils.ArrayList;

public enum ExecuteChooseKeyToReplace {

	INSTANCE;

	public void execute(Room room) {

		ArrayList<Token> list = room.getTokensList().getArrayList();
		list.removeFirst().getImageView().setVisible(false);

		EColor eColor = Rooms.INSTANCE.getRooms().getFirst().getTokensList().getArrayList()
				.getFirst().getEColor();

		KeyToken keyToken = TokenManager.INSTANCE.getKeyToken(eColor);
		list.addFirst(keyToken);

		room.getTokensList().relocateImageViews();

	}

}
