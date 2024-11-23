package utils;

import controller.Credentials;
import enums.EText;
import symbols.Symbol;
import symbols.SymbolHashmap;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.TextTypeEnum;

public enum TextManager {

	INSTANCE;

	private ArrayList<EText> eTextShowing = new ArrayList<>();

	private TextManager() {

	}

	public void showText(EText eText, String text) {

		if (this.eTextShowing.contains(eText))
			ShutDown.INSTANCE.execute();

		this.eTextShowing.addLast(eText);

		ArrayList<Class<? extends Symbol>> listSymbol = getSymbolList(text);
		eText.getText().showText(listSymbol);

		relocateTexts();

	}

	public void concealTexts() {

		for (EText eText : this.eTextShowing)
			eText.getText().concealText();

		this.eTextShowing.clear();

	}

	public EText getTextEnumOptionPressed(int textOptionID) {

		int currentTextOptionID = 0;

		for (EText eText : this.eTextShowing) {

			if (!eText.getTextTypeEnum().equals(TextTypeEnum.OPTION))
				continue;

			if (textOptionID == currentTextOptionID)
				return eText;

			currentTextOptionID++;

		}

		return null;

	}

	private void relocateTexts() {

		double x = Credentials.INSTANCE.cTextPanel.x;
		double y = Credentials.INSTANCE.cTextPanel.y;

		if (Credentials.INSTANCE.rearrangeTypeEnumText.equals(RearrangeTypeEnum.PIVOT)) {

			double totalY = this.eTextShowing.size() * Credentials.INSTANCE.textHeight;
			y -= totalY / 2;

		}

		for (EText eText : this.eTextShowing) {

			eText.getText().relocateTopLeft(x, y);
			y += Credentials.INSTANCE.textHeight;

		}

	}

	private ArrayList<Class<? extends Symbol>> getSymbolList(String string) {

		ArrayList<Class<? extends Symbol>> list = new ArrayList<>();

		for (int counter = 0; counter < string.length(); counter++) {

			String s = string.substring(counter, counter + 1);
			Class<? extends Symbol> classSymbol = SymbolHashmap.INSTANCE.getValue(s);
			list.addLast(classSymbol);

		}

		return list;

	}

}
