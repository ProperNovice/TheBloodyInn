package gameStatesDefault;

import gameStates.StartGame;
import utils.CameraView;
import utils.Flow;
import utils.SelectImageViewManager;
import utils.TextManager;

public class RestartGame extends GameState {

	@Override
	public void execute() {

		TextManager.INSTANCE.concealTexts();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Flow.INSTANCE.getFlow().clear();
		CameraView.INSTANCE.setCameraViewingSpot(1);

		Flow.INSTANCE.executeGameState(StartGame.class);

	}

}
