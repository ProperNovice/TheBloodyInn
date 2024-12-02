package gameStatesDefault;

import cards.Guest;
import cards.GuestModel;
import controller.Credentials;
import controller.Lists;
import enums.EText;
import javafx.scene.input.KeyCode;
import model.Room;
import model.Rooms;
import utils.Animation;
import utils.ArrayList;
import utils.CameraView;
import utils.Flow;
import utils.KeyCodeHandler;
import utils.Logger;
import utils.SelectImageViewManager;
import utils.TextManager;
import utils.Vector2;

public abstract class GameState {

	public abstract void execute();

	public final void handleTextOptionPressed(EText textEnum) {

		Logger.INSTANCE.log("text option executing");
		Logger.INSTANCE.logNewLine(textEnum);

		concealText();
		executeTextOption(textEnum);

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		if (Animation.INSTANCE.isAnimating())
			return;

		handleKeyPressed(keyCode);

		// e text

		int keyCodeETextID = KeyCodeHandler.INSTANCE.getKeyCodeETextInt(keyCode);

		if (keyCodeETextID != -1) {

			EText textEnumPressed = TextManager.INSTANCE.getTextEnumOptionPressed(keyCodeETextID);

			if (textEnumPressed == null)
				return;

			Logger.INSTANCE.log("executing key pressed -> " + keyCode);
			handleTextOptionPressed(textEnumPressed);

		}

		// camera view

		int cameraViewSpot = KeyCodeHandler.INSTANCE.getKeyCodeCameraViewInt(keyCode);

		if (cameraViewSpot > 0 && cameraViewSpot <= Credentials.INSTANCE.cameraViewSpots)
			CameraView.INSTANCE.setCameraViewingSpot(cameraViewSpot);

	}

	protected void handleKeyPressed(KeyCode keyCode) {

	}

	protected void executeTextOption(EText eText) {

	}

	public final void handleBackgroundPressed(Vector2 vector2) {

	}

	protected final ArrayList<Class<? extends GameState>> flow() {
		return Flow.INSTANCE.getFlow();
	}

	protected final void executeGameState(Class<? extends GameState> gameState) {
		Flow.INSTANCE.executeGameState(gameState);
	}

	protected final void proceedToNextGameState() {
		Flow.INSTANCE.proceed();
	}

	protected final void concealText() {
		TextManager.INSTANCE.concealTexts();
	}

	protected final SelectImageViewManager getSelectImageViewManager() {
		return SelectImageViewManager.INSTANCE;
	}

	public void handleRoomPressed(Room room) {

	}

	public final void handleGuestPressed(Guest guest) {

		for (Room room : Rooms.INSTANCE.getRooms())
			if (room.getGuestList().getArrayList().contains(guest))
				handleGuestPressedRooms(guest, guest.getGuestModel(), room);

		if (Lists.INSTANCE.hand.getArrayList().contains(guest))
			handleGuestPressedHand(guest, guest.getGuestModel());

		if (Lists.INSTANCE.annex.getArrayList().contains(guest))
			handleGuestPressedAnnex(guest, guest.getGuestModel());

		if (Lists.INSTANCE.bistro.getArrayList().contains(guest))
			handlePeasantPressedBistro(guest, guest.getGuestModel());

	}

	protected void handleGuestPressedRooms(Guest guest, GuestModel guestModel, Room room) {

	}

	protected void handleGuestPressedAnnex(Guest guest, GuestModel guestModel) {

	}

	protected void handleGuestPressedHand(Guest guest, GuestModel guestModel) {

	}

	protected void handlePeasantPressedBistro(Guest guest, GuestModel guestModel) {

	}

}
