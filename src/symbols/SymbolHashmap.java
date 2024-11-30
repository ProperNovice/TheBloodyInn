package symbols;

import utils.HashMap;

public enum SymbolHashmap {

	INSTANCE;

	private HashMap<String, Class<? extends Symbol>> hashMap = new HashMap<>();

	private SymbolHashmap() {

		// numbers

		this.hashMap.put("0", Symbol0.class);
		this.hashMap.put("1", Symbol1.class);
		this.hashMap.put("2", Symbol2.class);
		this.hashMap.put("3", Symbol3.class);
		this.hashMap.put("4", Symbol4.class);
		this.hashMap.put("5", Symbol5.class);
		this.hashMap.put("6", Symbol6.class);
		this.hashMap.put("7", Symbol7.class);
		this.hashMap.put("8", Symbol8.class);
		this.hashMap.put("9", Symbol9.class);

		// letters upper case

		this.hashMap.put("A", SymbolUpperCaseA.class);
		this.hashMap.put("B", SymbolUpperCaseB.class);
		this.hashMap.put("C", SymbolUpperCaseC.class);
		this.hashMap.put("D", SymbolUpperCaseD.class);
		this.hashMap.put("E", SymbolUpperCaseE.class);
		this.hashMap.put("F", SymbolUpperCaseF.class);
		this.hashMap.put("G", SymbolUpperCaseG.class);
		this.hashMap.put("H", SymbolUpperCaseH.class);
		this.hashMap.put("I", SymbolUpperCaseI.class);
		this.hashMap.put("J", SymbolUpperCaseJ.class);
		this.hashMap.put("K", SymbolUpperCaseK.class);
		this.hashMap.put("L", SymbolUpperCaseL.class);
		this.hashMap.put("M", SymbolUpperCaseM.class);
		this.hashMap.put("N", SymbolUpperCaseN.class);
		this.hashMap.put("O", SymbolUpperCaseO.class);
		this.hashMap.put("P", SymbolUpperCaseP.class);
		this.hashMap.put("Q", SymbolUpperCaseQ.class);
		this.hashMap.put("R", SymbolUpperCaseR.class);
		this.hashMap.put("S", SymbolUpperCaseS.class);
		this.hashMap.put("T", SymbolUpperCaseT.class);
		this.hashMap.put("U", SymbolUpperCaseU.class);
		this.hashMap.put("V", SymbolUpperCaseV.class);
		this.hashMap.put("W", SymbolUpperCaseW.class);
		this.hashMap.put("X", SymbolUpperCaseX.class);
		this.hashMap.put("Y", SymbolUpperCaseY.class);
		this.hashMap.put("Z", SymbolUpperCaseZ.class);

		// letters lower case

		this.hashMap.put("a", SymbolLowerCaseA.class);
		this.hashMap.put("b", SymbolLowerCaseB.class);
		this.hashMap.put("c", SymbolLowerCaseC.class);
		this.hashMap.put("d", SymbolLowerCaseD.class);
		this.hashMap.put("e", SymbolLowerCaseE.class);
		this.hashMap.put("f", SymbolLowerCaseF.class);
		this.hashMap.put("g", SymbolLowerCaseG.class);
		this.hashMap.put("h", SymbolLowerCaseH.class);
		this.hashMap.put("i", SymbolLowerCaseI.class);
		this.hashMap.put("j", SymbolLowerCaseJ.class);
		this.hashMap.put("k", SymbolLowerCaseK.class);
		this.hashMap.put("l", SymbolLowerCaseL.class);
		this.hashMap.put("m", SymbolLowerCaseM.class);
		this.hashMap.put("n", SymbolLowerCaseN.class);
		this.hashMap.put("o", SymbolLowerCaseO.class);
		this.hashMap.put("p", SymbolLowerCaseP.class);
		this.hashMap.put("q", SymbolLowerCaseQ.class);
		this.hashMap.put("r", SymbolLowerCaseR.class);
		this.hashMap.put("s", SymbolLowerCaseS.class);
		this.hashMap.put("t", SymbolLowerCaseT.class);
		this.hashMap.put("u", SymbolLowerCaseU.class);
		this.hashMap.put("v", SymbolLowerCaseV.class);
		this.hashMap.put("w", SymbolLowerCaseW.class);
		this.hashMap.put("x", SymbolLowerCaseX.class);
		this.hashMap.put("y", SymbolLowerCaseY.class);
		this.hashMap.put("z", SymbolLowerCaseZ.class);

		// rest

		this.hashMap.put("-", SymbolRestDash.class);
		this.hashMap.put("/", SymbolRestSlash.class);
		this.hashMap.put(":", SymbolRestColon.class);
		this.hashMap.put("&", SymbolRestAnd.class);
		this.hashMap.put(" ", SymbolRestSpace.class);
		this.hashMap.put("'", SymbolRestApostrophe.class);

	}

	public Class<? extends Symbol> getValue(String string) {
		return this.hashMap.getValue(string);
	}

}
