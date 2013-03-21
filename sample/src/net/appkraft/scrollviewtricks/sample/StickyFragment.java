package net.appkraft.scrollviewtricks.sample;

import net.appkraft.scrollviewtricks.ObservableScrollView;
import net.appkraft.scrollviewtricks.StickyScrollViewCallbacks;
import net.appkraft.scrollviewtricks.StickyScrollViewGlobalLayoutListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StickyFragment extends Fragment {
	private View mStickyView;
	private View mPlaceholderView;
	private ObservableScrollView mObservableScrollView;
	StickyScrollViewCallbacks mCallbacks;

	public StickyFragment() {
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

		mCallbacks = new StickyScrollViewCallbacks(mStickyView,
				mPlaceholderView, mObservableScrollView);

		mObservableScrollView.setCallbacks(mCallbacks);

		mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
				new StickyScrollViewGlobalLayoutListener(mStickyView,
						mPlaceholderView, mObservableScrollView, mCallbacks));

		return rootView;
	}
}
