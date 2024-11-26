package utils;

import utils.Interfaces.IImageViewAble;

public class IndicatorNumberImageView extends Indicator {

	public IndicatorNumberImageView() {
		super();
	}

	public IndicatorNumberImageView(double dimension, double coordinatesX, double coordinatesY) {
		super(dimension, new Vector2(coordinatesX, coordinatesY), 1);
	}

	public IndicatorNumberImageView(double dimension, double coordinatesX, double coordinatesY,
			int digits) {
		super(dimension, new Vector2(coordinatesX, coordinatesY), digits);
	}

	public IndicatorNumberImageView(double dimension, Vector2 vector2) {
		super(dimension, vector2, 1);
	}

	public IndicatorNumberImageView(double dimension, Vector2 vector2, int digits) {
		super(dimension, vector2, digits);
	}

	@Override
	protected IImageViewAble getMinusImageView() {
		return NumbersImageView.INSTANCE.getMinusImageView();
	}

	@Override
	protected IImageViewAble getCharacterImageView(String string) {
		return NumbersImageView.INSTANCE.getNumberImageView(Integer.parseInt(string));
	}

	@Override
	protected void relocate() {
		super.list.relocateImageViews();
	}

}