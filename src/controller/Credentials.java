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

	public Vector2 dCard, dCardAndGapBetweenComponents;
	public Vector2 cEntrance, cBistro, cExit, cRooms;

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

		// d card

		x = 361;
		y = 585;

		y = this.dFrame.y;
		y -= 2 * this.gapBetweenBorders;
		y -= 3 * this.dGapBetweenComponents.y;
		y /= 4;
		x = 361 * y / 585;
		this.dCard = new Vector2(x, y);

		// d card and gap between components

		this.dCardAndGapBetweenComponents = this.dCard.clone();
		this.dCardAndGapBetweenComponents.addVector2(this.dGapBetweenComponents);

		// c entrance

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cEntrance = new Vector2(x, y);

		// c bistro

		this.cBistro = this.cEntrance.clone();
		this.cBistro.addX(this.dCardAndGapBetweenComponents);

		// c exit

		this.cExit = this.cBistro.clone();
		this.cExit.addX(this.dCardAndGapBetweenComponents);

		// c rooms

		this.cRooms = this.cEntrance.clone();
		this.cRooms.addY(this.dCardAndGapBetweenComponents);
		this.cRooms.addX(this.dCard.x / 2);
		this.cRooms.addY(this.dCard.y / 2);

	}

}
