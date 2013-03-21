package net.appkraft.scrollviewtricks;

import android.view.View;

public class StickyScrollViewCallbacks implements ObservableScrollView.Callbacks {
	
	View mStickyView;
	View mPlaceholderView;
	ObservableScrollView mObservableScrollView;

	public StickyScrollViewCallbacks(View mStickyView, View mPlaceholderView,
			ObservableScrollView mObservableScrollView) {

		this.mStickyView = mStickyView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
		
	}
	
	@Override
	public void onScrollChanged() {
		
		mStickyView.setTranslationY(Math.max(0, mPlaceholderView.getTop()
				- mObservableScrollView.getScrollY()));
		
	}

}
