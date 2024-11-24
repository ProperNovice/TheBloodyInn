package cards;

import enums.EGuest;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Guest implements IImageViewAble {

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

		new ImageView(fileName, this);

	}

	public GuestModel getGuestModel() {
		return this.guestModel;
	}

}
