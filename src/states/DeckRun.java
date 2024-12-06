package states;

public enum DeckRun {

	INSTANCE;

	private int deckRun = 1;

	public void setFirst() {
		this.deckRun = 1;
	}

	public void setSecond() {
		this.deckRun++;
	}

	public int get() {
		return this.deckRun;
	}

}
