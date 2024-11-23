package enums;

import utils.Enums.TextTypeEnum;
import utils.Text;
import utils.TextManager;

public enum EText {

	CANCEL("Cancel", TextTypeEnum.OPTION), CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION), START_GAME("Start game", TextTypeEnum.OPTION),
	VOID_INDICATOR("", TextTypeEnum.INDICATOR), VOID_OPTION("", TextTypeEnum.OPTION),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR), YOU_WON("You won", TextTypeEnum.INDICATOR),

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
