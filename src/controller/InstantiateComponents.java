package controller;

import cards.Guest;
import enums.EGuest;
import states.Statistics;
import utils.ArrayList;
import utils.HashMap;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		addGuestsNonPeasants();
		addGuestsPeasants();
		Statistics.values();

	}

	private void addGuestsPeasants() {

		for (int counter = 1; counter <= 2; counter++) {

			Lists.INSTANCE.bistro.getArrayList().addLast(new Guest(EGuest.PEASANT_FEMALE));
			Lists.INSTANCE.bistro.getArrayList().addLast(new Guest(EGuest.PEASANT_MALE));

		}

		Lists.INSTANCE.bistro.getArrayList().saveOriginal();
		Lists.INSTANCE.bistro.getArrayList().shuffle();
		Lists.INSTANCE.bistro.relocateImageViews();

	}

	private void addGuestsNonPeasants() {

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, 4);
		hashMap.put(1, 4);
		hashMap.put(2, 3);
		hashMap.put(3, 1);

		ArrayList<EGuest> list = new ArrayList<>(EGuest.values());

		list.remove(EGuest.PEASANT_FEMALE);
		list.remove(EGuest.PEASANT_MALE);

		for (EGuest eGuest : list) {

			int rank = eGuest.getRank();
			int copies = hashMap.getValue(rank);

			for (int counter = 1; counter <= copies; counter++)
				Lists.INSTANCE.entrance.getArrayList().addLast(new Guest(eGuest));

		}

		for (int counter = 1; counter <= 2; counter++)
			Lists.INSTANCE.entrance.getArrayList().addLast(new Guest(EGuest.MAJOR));

		Lists.INSTANCE.entrance.getArrayList().saveOriginal();
		Lists.INSTANCE.entrance.relocateImageViews();

	}

}
