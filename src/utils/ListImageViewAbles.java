package utils;

import java.util.Iterator;

import utils.Enums.AnimationSynchEnum;
import utils.Enums.ImageViewActionEnum;
import utils.Enums.ListsSaveLoad;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.Interfaces.IImageViewAble;

public class ListImageViewAbles<T> implements Iterable<T> {

	private ArrayListImageView<T> arrayList = null;
	private IndicatorNumberImageView indicatorNumberImageView = new IndicatorNumberImageView();
	private CoordinatesList<T> coordinates = new CoordinatesList<>(this);
	private ListCredentials listCredentials = new ListCredentials();

	@SuppressWarnings("unchecked")
	public ListImageViewAbles() {

		this.arrayList = new ArrayListImageView<T>((ListImageViewAbles<IImageViewAble>) this,
				() -> showListSize());

		ListsSaveLoad.INSTANCE.lists.addLast((ListImageViewAbles<IImageViewAble>) this);

	}

	public final void layerZSort() {

		switch (this.listCredentials.layerZListEnum) {

		case TO_FRONT_FIRST_IMAGEVIEW:
			toFrontFirstImageView();
			break;

		case TO_BACK_FIRST_IMAGEVIEW:
			toBackFirstImageView();
			break;

		}

	}

	private void toFrontFirstImageView() {

		IImageViewAble imageViewAble = null;

		for (int counter = this.arrayList.size() - 1; counter >= 0; counter--) {

			imageViewAble = (IImageViewAble) this.arrayList.get(counter);
			getImageView(imageViewAble).toFront();

			toFrontDependency(imageViewAble);

		}

	}

	private void toBackFirstImageView() {

		IImageViewAble imageViewAble = null;

		for (T t : this.arrayList) {

			imageViewAble = (IImageViewAble) t;
			getImageView(imageViewAble).toFront();

			toFrontDependency(imageViewAble);

		}

	}

	private void toFrontDependency(IImageViewAble imageViewAble) {

		if (!ImageViewDependency.INSTANCE.hasDependency(imageViewAble))
			return;

		for (IImageViewAble dependency : ImageViewDependency.INSTANCE.getDependency(imageViewAble))
			getImageView(dependency).toFront();

	}

	public final void animateAsynchronous() {
		executeAction(ImageViewActionEnum.ANIMATE, AnimationSynchEnum.ASYNCHRONOUS);
	}

	public final void animateSynchronous() {
		executeAction(ImageViewActionEnum.ANIMATE, AnimationSynchEnum.SYNCHRONOUS);
	}

	public final void animateSynchronousLock() {

		animateSynchronous();
		Lock.INSTANCE.lock();

	}

	public final void relocateImageViews() {
		executeAction(ImageViewActionEnum.RELOCATE, null);
	}

	private void showListSize() {

		this.indicatorNumberImageView.clear();

		if (!this.listCredentials.showListSize)
			return;

		if (this.arrayList.isEmpty())
			return;

		// set list credentials

		IImageViewAble imageViewAble = (IImageViewAble) this.arrayList.getRandom();
		ImageView imageView = getImageView(imageViewAble);

		Vector2 center = this.listCredentials.coordinatesList.clone();

		RelocateTypeEnum relocateTypeEnum = this.listCredentials.relocateTypeEnum;

		center = CoordinatesRelocateType.INSTANCE.translateRelocateTypeCoordinatesFindCenter(center,
				imageView.getDimenions(), relocateTypeEnum);

		this.indicatorNumberImageView
				.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.PIVOT;

		this.indicatorNumberImageView.getListCredentials().coordinatesList = center;
		this.indicatorNumberImageView.getListCredentials();

		// set number

		int number = this.arrayList.size();

		double dimension = -1;

		if (getListCredentials().listQuantityRatioImageViewDimensions > 1)
			dimension = getListCredentials().listQuantityRatioImageViewDimensions;

		else {

			dimension = Math.min(imageView.getWidth(), imageView.getHeight());
			dimension *= getListCredentials().listQuantityRatioImageViewDimensions;

		}

		this.indicatorNumberImageView.setNumber(number, dimension);

	}

	private void executeAction(ImageViewActionEnum imageViewAction,
			AnimationSynchEnum animationSynch) {

		ArrayList<T> list = this.arrayList.clone();
		list.reverse();

		for (T t : list) {

			int index = this.arrayList.indexOf(t);
			Vector2 vector2 = this.coordinates.getCoordinate(index);

			IImageViewAble imageViewAble = (IImageViewAble) t;

			switch (imageViewAction) {

			case ANIMATE:
				Animation.INSTANCE.animateTopLeft(imageViewAble, vector2, animationSynch);
				break;

			case RELOCATE:

				getImageView(imageViewAble).relocateTopLeft(vector2);
				showListSize();

				if (!ImageViewDependency.INSTANCE.hasDependency(imageViewAble))
					break;

				for (IImageViewAble dependency : ImageViewDependency.INSTANCE
						.getDependency(imageViewAble))
					getImageView(dependency).relocateTopLeft(vector2);

				break;

			}

		}

		layerZSort();

	}

	public final ArrayList<T> getArrayList() {
		return this.arrayList;
	}

	public final ListCredentials getListCredentials() {
		return this.listCredentials;
	}

	@Override
	public final Iterator<T> iterator() {
		return this.arrayList.iterator();
	}

	protected ImageView getImageView(IImageViewAble imageViewAble) {
		return imageViewAble.getImageView();
	}

}
