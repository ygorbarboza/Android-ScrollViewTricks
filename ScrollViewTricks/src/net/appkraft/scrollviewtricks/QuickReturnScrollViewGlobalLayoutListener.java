package net.appkraft.scrollviewtricks;

import android.view.View;
import android.view.ViewTreeObserver;

public class QuickReturnScrollViewGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

	View mQuickReturnView;
	View mPlaceholderView;
	ObservableScrollView mObservableScrollView;;
    QuickReturnScrollViewCallbacks mCallbacks;

	public QuickReturnScrollViewGlobalLayoutListener(View mQuickReturnView, View mPlaceholderView,
			ObservableScrollView mObservableScrollView, 
		    QuickReturnScrollViewCallbacks mCallbacks) {

		this.mQuickReturnView = mQuickReturnView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
		this.mCallbacks = mCallbacks;
		
	}

	@Override
	public void onGlobalLayout() {
		
		mCallbacks.onScrollChanged();
		QuickReturnScrollViewCallbacks.mCachedVerticalScrollRange = mObservableScrollView.computeVerticalScrollRange();
		QuickReturnScrollViewCallbacks.mQuickReturnHeight = mQuickReturnView.getHeight();
		
	}

}
