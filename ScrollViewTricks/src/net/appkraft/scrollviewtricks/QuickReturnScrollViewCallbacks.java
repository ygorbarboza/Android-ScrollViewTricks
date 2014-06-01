package net.appkraft.scrollviewtricks;

import android.view.View;

public class QuickReturnScrollViewCallbacks implements ObservableScrollView.Callbacks {
	
    private static final int STATE_ONSCREEN = 0;
    private static final int STATE_OFFSCREEN = 1;
    private static final int STATE_RETURNING = 2;

	View mQuickReturnView;
	View mPlaceholderView;
	ObservableScrollView mObservableScrollView;
    private int mMinRawY = 0;
    private int mState = STATE_ONSCREEN;
    static int mQuickReturnHeight;
    static int mCachedVerticalScrollRange;

	public QuickReturnScrollViewCallbacks(View mQuickReturnView, View mPlaceholderView,
			ObservableScrollView mObservableScrollView) {

		this.mQuickReturnView = mQuickReturnView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
		
	}

	@Override
	public void onScrollChanged() {
		

        int rawY = mPlaceholderView.getTop() - Math.min(
                mCachedVerticalScrollRange - mObservableScrollView.getHeight(),
                mObservableScrollView.getScrollY());
        int translationY = 0;

        switch (mState) {
            case STATE_OFFSCREEN:
                if (rawY <= mMinRawY) {
                    mMinRawY = rawY;
                } else {
                    mState = STATE_RETURNING;
                }
                translationY = rawY;
                break;

            case STATE_ONSCREEN:
                if (rawY < -mQuickReturnHeight) {
                    mState = STATE_OFFSCREEN;
                    mMinRawY = rawY;
                }
                translationY = rawY;
                break;

            case STATE_RETURNING:
                translationY = (rawY - mMinRawY) - mQuickReturnHeight;
                if (translationY > 0) {
                    translationY = 0;
                    mMinRawY = rawY - mQuickReturnHeight;
                }

                if (rawY > 0) {
                    mState = STATE_ONSCREEN;
                    translationY = rawY;
                }

                if (translationY < -mQuickReturnHeight) {
                    mState = STATE_OFFSCREEN;
                    mMinRawY = rawY;
                }
                break;
        }

        ViewHelper.setTranslationY(mQuickReturnView, translationY);
        
        // mQuickReturnView.setTranslationY(translationY);
		
	}

}
