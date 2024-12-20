package tokens;

import cards.Guest;
import controller.Credentials;
import enums.EColor;
import enums.ELayerZ;
import model.Room;
import model.Rooms;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Token implements IImageViewAble {

	public Token() {

		String fileName = getFolder() + "/";
		fileName += getEColor().toString().toLowerCase();
		fileName += ".jpg";
		new ImageView(fileName, ELayerZ.TOKENS, this);
		getImageView().setWidthScale(Credentials.INSTANCE.dCard.x / 2);

	}

	@Override
	public final void handleMousePressedPrimary() {

		for (Room room : Rooms.INSTANCE.getRooms()) {

			if (!room.getTokensList().getArrayList().contains(this))
				continue;

			Flow.INSTANCE.getGameStateCurrent().handleRoomPressed(room);

			if (room.getGuestList().getArrayList().isEmpty())
				continue;

			Guest guest = room.getGuestList().getArrayList().getFirst();

			Flow.INSTANCE.getGameStateCurrent().handleGuestPressed(guest);

		}

	}

	public abstract EColor getEColor();

	protected abstract String getFolder();

}
