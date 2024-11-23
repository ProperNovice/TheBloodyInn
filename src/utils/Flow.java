package utils;

import java.lang.reflect.InvocationTargetException;

import gameStatesDefault.GameState;

public enum Flow {

	INSTANCE;

	private ArrayList<Class<? extends GameState>> flow = new ArrayList<>();
	private GameState gameStateCurrent = null;

	private Flow() {

	}

	public void proceed() {

		if (this.flow.isEmpty()) {

			Logger.INSTANCE.logNewLine("flow is empty");
			return;

		}

		Class<? extends GameState> gameStateClass = this.flow.removeFirst();

		Logger.INSTANCE.log("executing gamestate");
		Logger.INSTANCE.logNewLine(gameStateClass.getSimpleName());

		this.gameStateCurrent = getGameState(gameStateClass);
		this.gameStateCurrent.execute();

	}

	public void executeGameState(Class<? extends GameState> gameStateClass) {

		this.flow.addFirst(gameStateClass);
		proceed();

	}

	public ArrayList<Class<? extends GameState>> getFlow() {
		return this.flow;
	}

	public GameState getGameStateCurrent() {
		return this.gameStateCurrent;
	}

	public void print() {

		Logger.INSTANCE.logNewLine("/* printing flow");

		for (Class<? extends GameState> classGameState : this.flow)
			Logger.INSTANCE.log(classGameState.getSimpleName());

		Logger.INSTANCE.newLine();
		Logger.INSTANCE.logNewLine("*/ printing flow");

	}

	private GameState getGameState(Class<? extends GameState> gameStateClass) {

		try {

			return gameStateClass.getConstructor().newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			ShutDown.INSTANCE.execute();
			return null;

		}

	}

}
