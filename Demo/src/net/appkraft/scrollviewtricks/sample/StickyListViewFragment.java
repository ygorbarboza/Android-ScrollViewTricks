
package net.appkraft.scrollviewtricks.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;

import net.appkraft.scrollviewtricks.ObservableListView;
import net.appkraft.scrollviewtricks.StickyListViewCallbacks;
import net.appkraft.scrollviewtricks.StickyListViewGlobalLayoutListener;

public class StickyListViewFragment extends Fragment {
    private View mStickyView;

    private View mPlaceholderView;

    private ObservableListView mObservableListView;

    StickyListViewCallbacks mCallbacks;

    LayoutParams lp;

    String[] mExample = {
            "1", "2", "3", "4", "5", "6", "7", "2", "3", "4", "5", "6", "7", "2", "3", "4", "5",
            "6", "7", "5", "6", "7", "2", "3", "4", "5", "6", "7", "2", "3", "4", "5", "6", "7",
            "5", "6", "7", "2", "3", "4", "5", "6", "7", "2", "3", "4", "5", "6", "7", "5", "6",
            "7", "2", "3", "4", "5", "6", "7", "2", "3", "4", "5", "6", "7", "5", "6", "7", "2",
            "3", "4", "5", "6", "7", "2", "3", "4", "5", "6", "7"
    };

    public StickyListViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_content_listview,
                container, false);

        mObservableListView = (ObservableListView)rootView.findViewById(R.id.scroll_view);
        mStickyView = rootView.findViewById(R.id.sticky);
        mPlaceholderView = new View(getActivity());
        View dummy = new View(getActivity());

        lp = new LayoutParams(LayoutParams.MATCH_PARENT, 96);

        mPlaceholderView.setLayoutParams(lp);
        dummy.setLayoutParams(lp);

        mCallbacks = new StickyListViewCallbacks(mStickyView, mPlaceholderView, mObservableListView);

        mObservableListView.setCallbacks(mCallbacks);
        mObservableListView.addHeaderView(dummy);
        mObservableListView.addHeaderView(mPlaceholderView);
        mObservableListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, mExample));

        if (android.os.Build.VERSION.SDK_INT >= 11) {
            mObservableListView.getViewTreeObserver().addOnGlobalLayoutListener(
                    new StickyListViewGlobalLayoutListener(mStickyView, mPlaceholderView,
                            mObservableListView, mCallbacks));
        }

        return rootView;
    }
}
