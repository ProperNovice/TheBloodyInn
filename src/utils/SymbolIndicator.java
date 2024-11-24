package utils;

import symbols.Symbol;
import symbols.SymbolHashmap;
import utils.Interfaces.IImageViewAble;

public class SymbolIndicator extends Indicator {

	public SymbolIndicator() {
		super();
	}

	public SymbolIndicator(double dimension, double coordinatesX, double coordinatesY) {
		super(dimension, new Vector2(coordinatesX, coordinatesY), 1);
	}

	public SymbolIndicator(double dimension, double coordinatesX, double coordinatesY, int digits) {
		super(dimension, new Vector2(coordinatesX, coordinatesY), digits);
	}

	public SymbolIndicator(double dimension, Vector2 vector2) {
		super(dimension, vector2, 1);
	}

	public SymbolIndicator(double dimension, Vector2 vector2, int digits) {
		super(dimension, vector2, digits);
	}

	@Override
	protected IImageViewAble getMinusImageView() {
		return getCharacterImageView("-");
	}

	@Override
	protected IImageViewAble getCharacterImageView(String string) {

		Class<? extends Symbol> classSymbol = SymbolHashmap.INSTANCE.getValue(string);
		Symbol symbol = ObjectPool.INSTANCE.acquire(classSymbol);
		return symbol;

	}

	public final void setText(String string, double dimension) {
		execute(string, dimension);
	}

	public final void setText(String string) {
		setText(string, super.dimension);
	}

	@Override
	protected void relocate() {

		Vector2 coordinates = super.list.getListCredentials().coordinatesList;

		for (IImageViewAble imageViewAble : super.list) {

			imageViewAble.getImageView().relocateTopLeft(coordinates);
			coordinates.x += imageViewAble.getImageView().getWidth();

		}

	}

}