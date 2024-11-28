package cards;

import controller.Credentials;
import enums.EGuest;
import enums.ELayerZ;
import utils.Flow;
import utils.ImageView;

public class Guest extends Card {

	private GuestModel guestModel = null;

	public Guest(EGuest eGuest) {
		this.guestModel = new GuestModel(eGuest);
		createImageView();
	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleGuestPressed(this);
	}

	private void createImageView() {

		String fileName = "guests/";
		fileName += this.guestModel.getEGuestType().toString().toLowerCase();
		fileName += "/";
		fileName += this.guestModel.getEGuest().toString().toLowerCase();
		fileName += ".jpg";

		String back = "back/";

		if (this.guestModel.getEGuest().equals(EGuest.PEASANT_MALE)
				|| this.guestModel.getEGuest().equals(EGuest.PEASANT_FEMALE))
			back += "peasant";

		else
			back += this.guestModel.getRank();

		back += ".jpg";

		new ImageView(fileName, ELayerZ.GUESTS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCard);

		getImageView().setBack(back);

	}

	public GuestModel getGuestModel() {
		return this.guestModel;
	}

}
