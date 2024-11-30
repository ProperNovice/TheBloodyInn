package enums;

public enum EGuestType {

	ARTISAN(true), MERCHANT(true), NOBLE(true), PEASANT(false), POLICE(false), RELIGIOUS(true);

	private boolean canBuildAnnex;

	private EGuestType(boolean canBuildAnnex) {
		this.canBuildAnnex = canBuildAnnex;
	}

	public boolean canBuildAnnex() {
		return this.canBuildAnnex;
	}

}
