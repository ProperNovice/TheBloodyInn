package enums;

import utils.Enums.TextTypeEnum;
import utils.Text;
import utils.TextManager;

public enum EText {

	CANCEL("Cancel", TextTypeEnum.OPTION), CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION), START_GAME("Start game", TextTypeEnum.OPTION),
	VOID_INDICATOR("", TextTypeEnum.INDICATOR), VOID_OPTION("", TextTypeEnum.OPTION),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR), YOU_WON("You won", TextTypeEnum.INDICATOR),
	EVENING("Evening", TextTypeEnum.INDICATOR), CHOOSE_ROOM("Choose room", TextTypeEnum.INDICATOR),
	NIGHT("Night", TextTypeEnum.INDICATOR), ACTION("Action: ", TextTypeEnum.INDICATOR),
	CHOOSE_ACTION("Choose action", TextTypeEnum.INDICATOR),
	BRIBE_GUEST_OPTION("Bribe guest", TextTypeEnum.OPTION),
	BUILD_ANNEX_OPTION("Build annex", TextTypeEnum.OPTION),
	KILL_GUEST("Kill guest", TextTypeEnum.OPTION), BURY_CORPSE("Bury corpse", TextTypeEnum.OPTION),
	PASS_AND_LAUNDER_OPTION("Pass & launder", TextTypeEnum.OPTION),
	BRIBE_EXTRA_PEASANT("Bribe extra peasant", TextTypeEnum.INDICATOR),
	DONT_BRIBE("Don't bribe", TextTypeEnum.OPTION),
	BUILD_ANNEX_INDICATOR("Build an annex", TextTypeEnum.INDICATOR),
	CHOOSE_ANNEX_TO_BUILD("Choose annex to build", TextTypeEnum.INDICATOR),
	CHOOSE_CARDS_TO_DISCARD("Choose cards to discard", TextTypeEnum.INDICATOR),
	CHOOSE_GUEST_TO_KILL("Choose guest to kill", TextTypeEnum.INDICATOR),
	CHOOSE_GUEST_TO_BRIBE("Choose guest to bribe", TextTypeEnum.INDICATOR),
	CHOOSE_CORPSE_TO_BURY("Choose corpse to bury", TextTypeEnum.INDICATOR),
	PASS("Pass", TextTypeEnum.OPTION), LAUNDER("Launder", TextTypeEnum.OPTION),
	POLICE_INVESTIGATION("Police investigation", TextTypeEnum.INDICATOR),
	TRAVELERS_LEAVE("Travelers leave", TextTypeEnum.INDICATOR),
	PAY_WAGES("Pay wages", TextTypeEnum.INDICATOR),
	START_NEW_TURN("Start new turn", TextTypeEnum.INDICATOR),
	SHUFFLE_GUESTS("Shuffle guests", TextTypeEnum.INDICATOR),

	;

	private String string = null;
	private Text text = null;
	private TextTypeEnum textTypeEnum = null;

	private EText(String string, TextTypeEnum textTypeEnum) {

		this.string = string;
		this.textTypeEnum = textTypeEnum;
		this.text = new Text(this);

	}

	public void show() {
		TextManager.INSTANCE.showText(this, this.string);
	}

	public void showAdditionally(String string) {
		TextManager.INSTANCE.showText(this, this.string + string);
	}

	public void showAdditionally(int integer) {
		showAdditionally(Integer.toString(integer));
	}

	public void showInstead(String string) {
		TextManager.INSTANCE.showText(this, string);
	}

	public Text getText() {
		return this.text;
	}

	public TextTypeEnum getTextTypeEnum() {
		return this.textTypeEnum;
	}

}
