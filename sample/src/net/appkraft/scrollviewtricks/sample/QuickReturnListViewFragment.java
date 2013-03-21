package net.appkraft.scrollviewtricks.sample;

import net.appkraft.scrollviewtricks.ObservableListView;
import net.appkraft.scrollviewtricks.QuickReturnListViewCallbacks;
import net.appkraft.scrollviewtricks.QuickReturnListViewGlobalLayoutListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AbsListView.LayoutParams;

public class QuickReturnListViewFragment extends Fragment {
	private View mStickyView;
	private View mPlaceholderView;
	private ObservableListView mObservableListView;
	QuickReturnListViewCallbacks mCallbacks;
	LayoutParams lp;
	String[] mExample = {"1","2","3","4","5","6","7","2","3","4","5","6","7","2","3","4","5","6","7","5","6","7","2","3","4","5","6","7","2","3","4","5","6","7","5","6","7","2","3","4","5","6","7","2","3","4","5","6","7","5","6","7","2","3","4","5","6","7","2","3","4","5","6","7"};

	public QuickReturnListViewFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.fragment_content_listview, container, false);

		mObservableListView = (ObservableListView) rootView
				.findViewById(R.id.scroll_view);
		mStickyView = rootView.findViewById(R.id.sticky);
		mPlaceholderView = new View(getActivity());
		View dummy = new View(getActivity());
		
		lp = new LayoutParams(LayoutParams.FILL_PARENT, 96);
		
		mPlaceholderView.setLayoutParams(lp);
		dummy.setLayoutParams(lp);

		mCallbacks = new QuickReturnListViewCallbacks(mStickyView,
				mPlaceholderView, mObservableListView);

		mObservableListView.setCallbacks(mCallbacks);
		mObservableListView.addHeaderView(dummy);
		mObservableListView.addHeaderView(mPlaceholderView);
		mObservableListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mExample));

		mObservableListView.getViewTreeObserver().addOnGlobalLayoutListener(
				new QuickReturnListViewGlobalLayoutListener(mStickyView,
						mPlaceholderView, mObservableListView, mCallbacks));

		return rootView;
	}
}
