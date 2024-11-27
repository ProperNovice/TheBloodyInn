package cards;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class PlayerAid implements IImageViewAble {

	public PlayerAid() {

		String filePath = "playerAid/front.jpg";
		new ImageView(filePath, ELayerZ.GUESTS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCard);

	}

}
