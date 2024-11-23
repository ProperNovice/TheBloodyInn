package utils;

import utils.Interfaces.IImageViewAble;
import utils.Interfaces.IUpdateAble;

public class Sprite implements IUpdateAble {

	private HashMap<Integer, IImageViewAble> hashMap = new HashMap<>();
	private Vector2 coordinatesCenter = null;
	private int spriteShowing, totalFiles;
	private Runnable runnable = null;

	public Sprite(int totalFiles, String folder, Vector2 coordinatesCenter) {

		this.coordinatesCenter = coordinatesCenter;
		this.totalFiles = totalFiles;

		for (int counter = 1; counter <= totalFiles; counter++)
			this.hashMap.put(counter, new SpiteImageView(folder, counter));

	}

	public void playNormal() {

		this.spriteShowing = 0;

		this.runnable = () -> {
			this.spriteShowing++;
		};

		AnimationTimerFX.INSTANCE.updateEachFrame(this);

	}

	public void playReverse() {

		this.spriteShowing = this.totalFiles + 1;

		this.runnable = () -> {
			this.spriteShowing--;
		};

		AnimationTimerFX.INSTANCE.updateEachFrame(this);

	}

	@Override
	public void update() {

		if (this.hashMap.containsKey(this.spriteShowing))
			this.hashMap.getValue(this.spriteShowing).getImageView().setVisible(false);

		this.runnable.run();

		if (!this.hashMap.containsKey(this.spriteShowing))
			AnimationTimerFX.INSTANCE.remove(this);

		else {

			this.hashMap.getValue(this.spriteShowing).getImageView()
					.relocateCenter(this.coordinatesCenter);
			this.hashMap.getValue(this.spriteShowing).getImageView().setVisible(true);

		}

	}

	private class SpiteImageView implements IImageViewAble {

		public SpiteImageView(String folder, int fileNumber) {

			String filePath = folder + "/";

			if (fileNumber < 100)
				filePath += "0";

			if (fileNumber < 10)
				filePath += "0";

			filePath += fileNumber;
			filePath += ".png";

			new ImageView(filePath, this);
			getImageView().setVisible(false);

		}

	}

}
