package net.appkraft.scrollviewtricks;

import android.view.View;

public class QuickReturnListViewCallbacks implements
		ObservableListView.Callbacks {

	private static final int STATE_ONSCREEN = 0;
	private static final int STATE_OFFSCREEN = 1;
	private static final int STATE_RETURNING = 2;

	View mQuickReturnView;
	View mPlaceholderView;
	ObservableListView mObservableScrollView;
	private int mMinRawY = 0;
	private int mState = STATE_ONSCREEN;
	static int mQuickReturnHeight;
	static int mQuickReturnY;
	static int mCachedVerticalScrollRange;
	private int mQuickReturnListPosition = -1;

	public QuickReturnListViewCallbacks(View mQuickReturnView,
			View mPlaceholderView, ObservableListView mObservableScrollView) {

		this.mQuickReturnView = mQuickReturnView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
	}

	@Override
	public void onScrollChanged() {
		
		int scroll = mObservableScrollView.getScroll();
//				- Math.min(
//						0,
//						mObservableScrollView.getScroll());
		int translationY = 0;

		if (mQuickReturnListPosition == -1) {
            if (mObservableScrollView != null && mPlaceholderView != null) {
                mQuickReturnListPosition = mObservableScrollView
                        .getPositionForView(mPlaceholderView);
                mQuickReturnY = mObservableScrollView.getViewHeigth(mPlaceholderView);
            }

		}

		int rawY = mQuickReturnY + (mPlaceholderView.getTop() < -scroll ? mPlaceholderView.getTop() : -scroll);
		int prevRawY = rawY;
		
		if(rawY < -mQuickReturnHeight){
			
			rawY = -mQuickReturnHeight;
			
		}

		switch (mState) {
		case STATE_OFFSCREEN:
			if (prevRawY <= mMinRawY) {
				mMinRawY = prevRawY;
			} else {
				mState = STATE_RETURNING;
			}
			translationY = rawY;
			break;

		case STATE_ONSCREEN:
			if (prevRawY < -mQuickReturnHeight) {
				mState = STATE_OFFSCREEN;
				mMinRawY = rawY;
			}

			translationY = rawY;

			break;

		case STATE_RETURNING:
			translationY = (prevRawY - mMinRawY) - mQuickReturnHeight;
			if (translationY > 0) {
				translationY = 0;
				mMinRawY = prevRawY - mQuickReturnHeight;
			}

			if (prevRawY > 0) {
				mState = STATE_ONSCREEN;
				translationY = prevRawY;
			}

			if (translationY < -mQuickReturnHeight) {
				mState = STATE_OFFSCREEN;
				mMinRawY = prevRawY;
			}
			break;
		}

		// mQuickReturnView.setTranslationY(translationY);
		ViewHelper.setTranslationY(mQuickReturnView, translationY);

	}

}
