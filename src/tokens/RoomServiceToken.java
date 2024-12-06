package tokens;

public abstract class RoomServiceToken extends Token {

	public RoomServiceToken() {

	}

	@Override
	protected String getFolder() {
		return "room service";
	}

}
