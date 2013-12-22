package net.appkraft.scrollviewtricks;

import android.view.View;
import android.view.ViewTreeObserver;

public class StickyScrollViewGlobalLayoutListener implements
		ViewTreeObserver.OnGlobalLayoutListener {

	View mStickyView;
	View mPlaceholderView;
	ObservableScrollView mObservableScrollView;
	StickyScrollViewCallbacks mCallbacks;

	public StickyScrollViewGlobalLayoutListener(View mStickyView,
			View mPlaceholderView, ObservableScrollView mObservableScrollView,
			StickyScrollViewCallbacks mCallbacks) {

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
