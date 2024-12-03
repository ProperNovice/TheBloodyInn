package states;

public enum WagesNeedToBePaid {

	INSTANCE;

	private int amount = -1;

	public void set(int amount) {
		this.amount = amount;
	}

	public int get() {
		return this.amount;
	}

}
