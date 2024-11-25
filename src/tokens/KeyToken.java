package tokens;

import controller.Credentials;
import enums.EColor;
import enums.ELayerZ;
import utils.ImageView;

public class KeyToken extends Token {

	public KeyToken(EColor eColor) {

		String fileName = "keys/";
		fileName += eColor.toString().toLowerCase();
		fileName += ".jpg";
		new ImageView(fileName, ELayerZ.TOKENS, this);
		getImageView().setWidthScale(Credentials.INSTANCE.dCard.x / 2);

	}

}
