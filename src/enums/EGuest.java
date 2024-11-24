package enums;

import utils.ShutDown;

public enum EGuest {

	CULTIVATOR(EGuestType.ARTISAN, 0), MECHANIC(EGuestType.ARTISAN, 1),
	DISTILLER(EGuestType.ARTISAN, 2), BUTCHER(EGuestType.ARTISAN, 3),
	GARDENER(EGuestType.ARTISAN, 3), LANDSCAPER(EGuestType.ARTISAN, 3),
	NEWSBOY(EGuestType.MERCHANT, 0), REPRESENTATIVE(EGuestType.MERCHANT, 1),
	CONCIERGE(EGuestType.MERCHANT, 2), BREWER(EGuestType.MERCHANT, 3),
	GROCER(EGuestType.MERCHANT, 3), SHOPKEEPER(EGuestType.MERCHANT, 3), BARON(EGuestType.NOBLE, 0),
	VISCOUNT(EGuestType.NOBLE, 1), COUNT(EGuestType.NOBLE, 2), DUKE(EGuestType.NOBLE, 3),
	MARQUIS(EGuestType.NOBLE, 3), PRINCE(EGuestType.NOBLE, 3), PEACEKEEPER(EGuestType.POLICE, 0),
	BRIGADIER(EGuestType.POLICE, 1), BRIGADIER_CHIEF(EGuestType.POLICE, 2),
	MAJOR(EGuestType.POLICE, 3), NOVICE(EGuestType.RELIGIOUS, 0), MONK(EGuestType.RELIGIOUS, 1),
	ABBOT(EGuestType.RELIGIOUS, 2), ARCHBISHOP(EGuestType.RELIGIOUS, 3),
	BISHOP(EGuestType.RELIGIOUS, 3), PRIEST(EGuestType.RELIGIOUS, 3),
	PEASANT_FEMALE(EGuestType.PEASANT, 0), PEASANT_MALE(EGuestType.PEASANT, 0),

	;

	private EGuestType eGuestType = null;
	private int rank = -1;

	private int getEGuestType = 0, getRank = 0;

	private EGuest(EGuestType eGuestType, int rank) {

		this.eGuestType = eGuestType;
		this.rank = rank;

	}

	public EGuestType getEGuestType() {

		this.getEGuestType++;

		if (this.getEGuestType > 1)
			ShutDown.INSTANCE.execute();

		return this.eGuestType;

	}

	public int getRank() {

		this.getRank++;

		if (this.getRank > 1)
			ShutDown.INSTANCE.execute();

		return this.rank;

	}

}
