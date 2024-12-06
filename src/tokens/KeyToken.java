package tokens;

public abstract class KeyToken extends Token {

	public KeyToken() {

	}

	@Override
	protected String getFolder() {
		return "keys";
	}

}
