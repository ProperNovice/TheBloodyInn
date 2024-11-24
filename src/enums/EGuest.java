package enums;

public enum EGuest {

	;

	private EGuestType eGuestType = null;
	private int rank = -1;

	private EGuest(EGuestType eGuestType, int rank) {

		this.eGuestType = eGuestType;
		this.rank = rank;

	}

	public EGuestType getEGuestType() {
		return this.eGuestType;
	}

	public int getRank() {
		return this.rank;
	}

}
