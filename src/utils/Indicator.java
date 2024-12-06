package utils;

import utils.Enums.LayerZListEnum;
import utils.Enums.ListsSaveLoad;
import utils.Interfaces.IImageViewAble;

public abstract class Indicator {

	protected ListImageViewAbles<IImageViewAble> list = null;
	protected double dimension = 100;
	private int digits = 1;

	public Indicator() {

	}

	public Indicator(double dimension, double coordinatesX, double coordinatesY) {
		this(dimension, new Vector2(coordinatesX, coordinatesY), 1);
	}

	public Indicator(double dimension, double coordinatesX, double coordinatesY, int digits) {
		this(dimension, new Vector2(coordinatesX, coordinatesY), digits);
	}

	public Indicator(double dimension, Vector2 vector2) {
		this(dimension, vector2, 1);
	}

	public Indicator(double dimension, Vector2 vector2, int digits) {

		this.dimension = dimension;
		this.digits = digits;

		this.list = new ListImageViewAbles<>();
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;

		this.list.getListCredentials().coordinatesList = vector2;

		ListsSaveLoad.INSTANCE.lists.remove(this.list);

	}

	protected final void execute(String string, double dimension) {

		createList();

		if (dimension == 0)
			ShutDown.INSTANCE.execute();

		// clear currents

		clear();

		// create list of strings

		for (int counter = 0; counter < string.length(); counter++) {

			String s = string.substring(counter, counter + 1);
			IImageViewAble imageViewAble = getCharacterImageView(s);
			this.list.getArrayList().addLast(imageViewAble);

		}

		// resize image views

		for (IImageViewAble imageViewAbleTemp : this.list)
			imageViewAbleTemp.getImageView().setHeightScale(dimension);

		// set gap between components to 0

		this.list.getListCredentials().gapBetweenComponents = new Vector2(dimension, 0);

		// relocate

		relocate();

	}

	public final void setNumber(int number, double dimension) {

		String string = Integer.toString(number);

		if (number > 0)
			while (string.length() < this.digits)
				string = "0" + string;

		execute(string, dimension);

	}

	public final void setNumber(int number) {
		setNumber(number, this.dimension);
	}

	protected abstract IImageViewAble getMinusImageView();

	protected abstract IImageViewAble getCharacterImageView(String string);

	protected abstract void relocate();

	public void clear() {

		createList();

		for (IImageViewAble imageViewAble : this.list)
			imageViewAble.getImageView().setVisible(false);

		this.list.getArrayList().clear();

	}

	public ListCredentials getListCredentials() {

		createList();
		return this.list.getListCredentials();

	}

	private void createList() {

		if (this.list != null)
			return;

		this.list = new ListImageViewAbles<>();
		ListsSaveLoad.INSTANCE.lists.remove(this.list);
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;

	}

}