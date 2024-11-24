package controller;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "The Bloody Inn", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public final double stagePixesOnTheLeft = 180, gapBetweenBorders = 10, textHeight = 50,
			selectEventHandlerAbleDimension = 100, imageViewCloneWidth = 200, animationStep = 4,
			cameraViewSpots = 1;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;
	public boolean primaryStageFullScreen = false;

	private Credentials() {

		double x = 0, y = 0;

		// frame

		this.dFrame = new Vector2(2560, 1440);
		this.dFrame.x = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.dFrame.y = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		if (!this.primaryStageFullScreen) {

			this.dFrame.x -= 636 + 4;
			this.dFrame.y -= 72;

		}

		// gaps

		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// camera view

		this.dCameraView = new Vector2(1, 1);

		// c text panel

		x = 0;
		y = 0;

		this.cTextPanel = new Vector2(x, y);

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewClone = new Vector2(x, y);

	}

}
