package states;

import cards.Guest;

public enum CorpseBuried {

	INSTANCE;

	private Guest corpseBuried = null;

	public void set(Guest guest) {
		this.corpseBuried = guest;
	}

	public Guest get() {
		return this.corpseBuried;
	}

}
