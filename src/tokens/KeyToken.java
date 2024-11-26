package tokens;

import controller.Credentials;
import enums.EColor;
import enums.ELayerZ;
import utils.ImageView;

public abstract class KeyToken extends Token {

	public KeyToken() {

		String fileName = "keys/";
		fileName += getEColor().toString().toLowerCase();
		fileName += ".jpg";
		new ImageView(fileName, ELayerZ.TOKENS, this);
		getImageView().setWidthScale(Credentials.INSTANCE.dCard.x / 2);

	}

	protected abstract EColor getEColor();

}
