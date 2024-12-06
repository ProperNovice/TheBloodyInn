package model;

import enums.EColor;
import tokens.KeyToken;
import tokens.KeyTokenBlue;
import tokens.KeyTokenGreen;
import tokens.KeyTokenRed;
import tokens.KeyTokenYellow;
import tokens.RoomServiceToken;
import tokens.RoomServiceTokenBlue;
import tokens.RoomServiceTokenGreen;
import tokens.RoomServiceTokenRed;
import tokens.RoomServiceTokenYellow;
import utils.HashMap;
import utils.ObjectPool;

public enum TokenManager {

	INSTANCE;

	private HashMap<EColor, Class<? extends KeyToken>> keyTokens = new HashMap<>();
	private HashMap<EColor, Class<? extends RoomServiceToken>> roomServiceTokens = new HashMap<>();

	private TokenManager() {

		this.keyTokens.put(EColor.BLUE, KeyTokenBlue.class);
		this.keyTokens.put(EColor.GREEN, KeyTokenGreen.class);
		this.keyTokens.put(EColor.RED, KeyTokenRed.class);
		this.keyTokens.put(EColor.YELLOW, KeyTokenYellow.class);

		this.roomServiceTokens.put(EColor.BLUE, RoomServiceTokenBlue.class);
		this.roomServiceTokens.put(EColor.GREEN, RoomServiceTokenGreen.class);
		this.roomServiceTokens.put(EColor.RED, RoomServiceTokenRed.class);
		this.roomServiceTokens.put(EColor.YELLOW, RoomServiceTokenYellow.class);
		
		System.out.println(this.keyTokens.getValue(EColor.BLUE));

	}

	public KeyToken getKeyToken(EColor eColor) {
		return ObjectPool.INSTANCE.acquire(this.keyTokens.getValue(eColor));
	}

	public RoomServiceToken getRoomServiceToken(EColor eColor) {
		return ObjectPool.INSTANCE.acquire(this.roomServiceTokens.getValue(eColor));
	}

}
