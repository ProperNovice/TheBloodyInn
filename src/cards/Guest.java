package cards;

import controller.Credentials;
import enums.EGuest;
import enums.ELayerZ;
import utils.ImageView;

public class Guest extends Card {

	private GuestModel guestModel = null;

	public Guest(EGuest eGuest) {
		this.guestModel = new GuestModel(eGuest);
		createImageView();
	}

	@Override
	public void handleMousePressedPrimary() {

	}

	private void createImageView() {

		String fileName = "guests/";
		fileName += this.guestModel.getEGuestType().toString().toLowerCase();
		fileName += "/";
		fileName += this.guestModel.getEGuest().toString().toLowerCase();
		fileName += ".jpg";

		new ImageView(fileName, ELayerZ.GUESTS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCard);

	}

	public GuestModel getGuestModel() {
		return this.guestModel;
	}

}
