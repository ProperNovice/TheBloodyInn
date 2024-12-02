package model;

import controller.Credentials;
import utils.IndicatorSymbol;
import utils.Vector2;

public enum Statistics {

	INSTANCE;

	private int francChecks = 1, francCash = 5, annex = 1;
	private IndicatorSymbol francChecksGui, francCashGui, annexGui;

	private Statistics() {

		createIndicators();
		resetIndicators();
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

	public void addAnnex(int annex) {
		this.annex += annex;
		updateGUI();
	}

	public void reduceAnnex() {
		this.annex--;
		updateGUI();
	}

	public void resetIndicators() {

		this.francChecks = 1;
		this.francCash = 5;
		this.annex = 1;
		updateGUI();

	}

	public int getChecks() {
		return this.francChecks;
	}

	public int getCash() {
		return this.francCash;
	}

	public int getAnnex() {
		return this.annex;
	}

	private void updateGUI() {

		// franc checks

		this.francChecksGui.setText("Checks: " + this.francChecks);

		// franc cash

		this.francCashGui.setText("Cash: " + this.francCash + "/40");

		// annex

		this.annexGui.setText("Annex: " + this.annex);

	}

	private void createIndicators() {

		double dimensions = Credentials.INSTANCE.textHeight;
		Vector2 vector2 = Credentials.INSTANCE.cFranc;

		// franc checks

		this.francChecksGui = new IndicatorSymbol(dimensions, vector2);

		// franc cash

		vector2 = vector2.clone();
		vector2.addY(dimensions);

		this.francCashGui = new IndicatorSymbol(dimensions, vector2);

		// annex

		vector2 = vector2.clone();
		vector2.addY(dimensions);
		this.annexGui = new IndicatorSymbol(dimensions, vector2);

	}

}
