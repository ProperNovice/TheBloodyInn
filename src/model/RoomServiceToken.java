package model;

import controller.Credentials;
import enums.EColor;
import enums.ELayerZ;
import utils.ImageView;

public class RoomServiceToken extends Token {

	public RoomServiceToken(EColor eColor) {

		String fileName = "room service/";
		fileName += eColor.toString().toLowerCase();
		fileName += ".jpg";
		new ImageView(fileName, ELayerZ.TOKENS, this);
		getImageView().setWidthScale(Credentials.INSTANCE.dCard.x / 2);

	}

}
