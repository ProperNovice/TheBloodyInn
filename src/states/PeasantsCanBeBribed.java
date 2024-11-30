package states;

public enum PeasantsCanBeBribed {

	INSTANCE;

	private int peasantsCanBeBribed = -1;

	public void reset(int amount) {
		this.peasantsCanBeBribed = amount;
	}

	public void reducePeasantBribed() {
		this.peasantsCanBeBribed--;
	}

	public boolean canBeBribed() {
		return this.peasantsCanBeBribed > 0;
	}

}
