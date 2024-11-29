package tokens;

import cards.Guest;
import controller.Credentials;
import enums.EColor;
import enums.ELayerZ;
import model.Room;
import model.Rooms;
import utils.Flow;
import utils.ImageView;

public abstract class KeyToken extends Token {

	public KeyToken() {

		String fileName = "keys/";
		fileName += getEColor().toString().toLowerCase();
		fileName += ".jpg";
		new ImageView(fileName, ELayerZ.TOKENS, this);
		getImageView().setWidthScale(Credentials.INSTANCE.dCard.x / 2);

	}

	@Override
	public void handleMousePressedPrimary() {

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (!room.getTokensList().getArrayList().contains(this))
				continue;

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();

			Flow.INSTANCE.getGameStateCurrent().handleGuestPressed(guest);

		}

	}

	protected abstract EColor getEColor();

}
