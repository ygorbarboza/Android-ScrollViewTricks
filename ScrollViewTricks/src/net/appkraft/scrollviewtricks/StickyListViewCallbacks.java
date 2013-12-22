package net.appkraft.scrollviewtricks;

import android.view.View;

public class StickyListViewCallbacks implements ObservableListView.Callbacks {
	
	View mStickyView;
	View mPlaceholderView;
	ObservableListView mObservableScrollView;

	public StickyListViewCallbacks(View mStickyView, View mPlaceholderView,
			ObservableListView mObservableScrollView) {

		this.mStickyView = mStickyView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
		
	}
	
	@Override
	public void onScrollChanged() {
		ViewHelper.setTranslationY(mStickyView, Math.max(0, mPlaceholderView.getTop()
                - mObservableScrollView.getScrollY()));
		// mStickyView.setTranslationY(Math.max(0, mPlaceholderView.getTop()
		//		- mObservableScrollView.getScrollY()));
		
	}

}
