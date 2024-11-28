package symbols;

import controller.Credentials;
import enums.ELayerZ;
import enums.EText;
import utils.Enums.TextTypeEnum;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Symbol implements IImageViewAble {

	public Symbol() {

		create();

	}

	@Override
	public void handleMousePressedPrimary() {

		for (EText eText : EText.values())
			if (eText.getTextTypeEnum().equals(TextTypeEnum.OPTION))
				if (eText.getText().containsSymbol(this))
					eText.getText().handleMousePressedPrimary();

	}

	@Override
	public void handleMouseEntered() {

		for (EText eText : EText.values())
			if (eText.getText().containsSymbol(this))
				eText.getText().handleMouseEntered();

	}

	@Override
	public void handleMouseExited() {

		for (EText eText : EText.values())
			if (eText.getText().containsSymbol(this))
				eText.getText().handleMouseExited();

	}

	private void create() {

		String filePath = "";
		filePath += "misc/symbols/";
		filePath += this.getFolder();
		filePath += "/";
		filePath += getSymbol();
		filePath += ".png";

		new ImageView(filePath, ELayerZ.ICONS_MISC, this);
		getImageView().setHeightScale(Credentials.INSTANCE.textHeight);

	}

	protected abstract String getFolder();

	protected abstract String getSymbol();

}
