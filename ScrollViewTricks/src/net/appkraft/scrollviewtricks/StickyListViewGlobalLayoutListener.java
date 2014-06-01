package net.appkraft.scrollviewtricks;

import android.view.View;
import android.view.ViewTreeObserver;

public class StickyListViewGlobalLayoutListener implements
		ViewTreeObserver.OnGlobalLayoutListener {

	View mStickyView;
	View mPlaceholderView;
	ObservableListView mObservableScrollView;
	StickyListViewCallbacks mCallbacks;

	public StickyListViewGlobalLayoutListener(View mStickyView,
			View mPlaceholderView, ObservableListView mObservableScrollView,
			StickyListViewCallbacks mCallbacks) {

		this.mStickyView = mStickyView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
		this.mCallbacks = mCallbacks;

	}

	@Override
	public void onGlobalLayout() {

		mCallbacks.onScrollChanged();

	}

}
