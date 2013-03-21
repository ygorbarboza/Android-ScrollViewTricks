package net.appkraft.scrollviewtricks.sample;

import net.appkraft.scrollviewtricks.ObservableScrollView;
import net.appkraft.scrollviewtricks.QuickReturnScrollViewCallbacks;
import net.appkraft.scrollviewtricks.QuickReturnScrollViewGlobalLayoutListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuickReturnFragment extends Fragment {
	private View mStickyView;
	private View mPlaceholderView;
	private ObservableScrollView mObservableScrollView;
	QuickReturnScrollViewCallbacks mCallbacks;

	public QuickReturnFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.fragment_content_scrollview, container, false);

		mObservableScrollView = (ObservableScrollView) rootView
				.findViewById(R.id.scroll_view);
		mStickyView = rootView.findViewById(R.id.sticky);
		mPlaceholderView = rootView.findViewById(R.id.placeholder);

		mCallbacks = new QuickReturnScrollViewCallbacks(mStickyView,
				mPlaceholderView, mObservableScrollView);

		mObservableScrollView.setCallbacks(mCallbacks);

		mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
				new QuickReturnScrollViewGlobalLayoutListener(mStickyView,
						mPlaceholderView, mObservableScrollView, mCallbacks));

		return rootView;
	}
}
