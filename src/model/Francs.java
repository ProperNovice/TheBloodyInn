package model;

import controller.Credentials;
import utils.IndicatorSymbol;
import utils.Vector2;

public enum Francs {

	INSTANCE;

	private int francChecks = 1, francCash = 5;
	private IndicatorSymbol francChecksGui, francCashGui;

	private Francs() {

		createIndicators();
		updateGUI();

	}

	public void addCash(int cash) {

		this.francCash += cash;
		this.francCash = Math.min(this.francCash, 40);
		updateGUI();

	}

	public void removeCash(int cash) {

		this.francCash -= cash;
		updateGUI();

	}

	public void addChecks(int checks) {
		this.francChecks += checks;
		updateGUI();
	}

	public int getChecks() {
		return this.francChecks;
	}

	public int getCash() {
		return this.francCash;
	}

	private void updateGUI() {

		// franc checks

		this.francChecksGui.setText("Checks: " + this.francChecks);

		// franc cash

		this.francCashGui.setText("Cash: " + this.francCash + "/40");

	}

	private void createIndicators() {

		double dimensions = Credentials.INSTANCE.textHeight;
		Vector2 vector2 = Credentials.INSTANCE.cFranc;

		// franc checks gui

		this.francChecksGui = new IndicatorSymbol(dimensions, vector2);

		// franc cash gui

		vector2 = vector2.clone();
		vector2.addY(dimensions);

		this.francCashGui = new IndicatorSymbol(dimensions, vector2);

	}

}
