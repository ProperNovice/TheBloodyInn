package utils;

import controller.Credentials;
import enums.EText;
import symbols.Symbol;
import symbols.TextOption;
import symbols.TextOptionSelected;
import symbols.TextOptionUnselected;
import utils.Enums.TextTypeEnum;
import utils.Interfaces.IUpdateAble;

public class Text implements IUpdateAble {

	private ArrayList<Symbol> listSymbols = new ArrayList<>();
	private EText eText = null;
	private TextOption textOption = null;
	private Runnable runnableMouseEnteredExited = null;

	public Text(EText eText) {
		this.eText = eText;
	}

	public void showText(ArrayList<Class<? extends Symbol>> listSymbol) {

		for (Class<? extends Symbol> classSymbol : listSymbol) {

			Symbol symbol = ObjectPool.INSTANCE.acquire(classSymbol);
			this.listSymbols.addLast(symbol);
			symbol.getImageView().setHeightScale(Credentials.INSTANCE.textHeight);

		}

	}

	public void relocateTopLeft(double x, double y) {

		for (Symbol symbol : this.listSymbols) {

			symbol.getImageView().relocateTopLeft(x, y);
			x += symbol.getImageView().getWidth();

		}

		if (this.eText.getTextTypeEnum().equals(TextTypeEnum.INDICATOR))
			return;

		setTextOptionUnselected();

	}

	public void concealText() {

		for (Symbol symbol : this.listSymbols)
			symbol.getImageView().setVisible(false);

		this.listSymbols.clear();

		if (this.textOption == null)
			return;

		this.textOption.getImageView().setVisible(false);
		this.textOption = null;

	}

	private void releaseTextOption() {

		if (this.textOption == null)
			return;

		this.textOption.getImageView().setVisible(false);
		this.textOption = null;

	}

	private void setTextOptionUnselected() {

		releaseTextOption();
		this.textOption = ObjectPool.INSTANCE.acquire(TextOptionUnselected.class);
		resizeTextOption();

	}

	private void setTextOptionSelected() {

		releaseTextOption();
		this.textOption = ObjectPool.INSTANCE.acquire(TextOptionSelected.class);
		resizeTextOption();

	}

	private void resizeTextOption() {

		double width = 0;
		double height = Credentials.INSTANCE.textHeight;

		for (Symbol symbol : this.listSymbols)
			width += symbol.getImageView().getWidth();

		this.textOption.getImageView().setWidth(width);
		this.textOption.getImageView().setHeight(height);

		this.textOption.getImageView().relocateTopLeft(
				this.listSymbols.getFirst().getImageView().getCoordinatesTopLeft());

		this.textOption.getImageView().toBack();

	}

	public boolean containsSymbol(Symbol symbol) {
		return this.listSymbols.contains(symbol);
	}

	public boolean containsTextOption(TextOption textOption) {
		return this.textOption == textOption;
	}

	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleTextOptionPressed(this.eText);
	}

	public void handleMouseEntered() {

		if (!this.eText.getTextTypeEnum().equals(TextTypeEnum.OPTION))
			return;

		this.runnableMouseEnteredExited = () -> setTextOptionSelected();
		AnimationTimerFX.INSTANCE.updateNextFrame(this);

	}

	public void handleMouseExited() {

		if (!this.eText.getTextTypeEnum().equals(TextTypeEnum.OPTION))
			return;

		this.runnableMouseEnteredExited = () -> setTextOptionUnselected();
		AnimationTimerFX.INSTANCE.updateNextFrame(this);

	}

	@Override
	public void update() {
		this.runnableMouseEnteredExited.run();
	}

}
