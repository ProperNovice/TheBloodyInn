package symbols;

import enums.ELayerZ;
import enums.EText;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class TextOption implements IImageViewAble {

	public TextOption() {

		String filePath = "";
		filePath += "misc/symbols/";
		filePath += getFilePath();
		filePath += ".png";

		new ImageView(filePath, ELayerZ.ICONS_MISC, this);

	}

	@Override
	public void handleMousePressedPrimary() {

		for (EText eText : EText.values())
			if (eText.getText().containsTextOption(this))
				eText.getText().handleMousePressedPrimary();

	}

	@Override
	public void handleMouseEntered() {

		for (EText eText : EText.values())
			if (eText.getText().containsTextOption(this))
				eText.getText().handleMouseEntered();

	}

	@Override
	public void handleMouseExited() {

		for (EText eText : EText.values())
			if (eText.getText().containsTextOption(this))
				eText.getText().handleMouseExited();

	}

	protected abstract String getFilePath();

}
