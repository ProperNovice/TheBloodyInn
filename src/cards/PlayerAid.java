package cards;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;

public class PlayerAid extends Card {

	public PlayerAid() {

		String filePath = "playerAid/front.jpg";
		new ImageView(filePath, ELayerZ.GUESTS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCard);

	}

}
