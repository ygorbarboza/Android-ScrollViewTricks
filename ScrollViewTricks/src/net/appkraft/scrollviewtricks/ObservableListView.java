package net.appkraft.scrollviewtricks;

import java.util.Dictionary;
import java.util.Hashtable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * A custom ScrollView that can accept a scroll listener.
 */
public class ObservableListView extends ListView {
    private Callbacks mCallbacks;

    public ObservableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mCallbacks != null) {
            mCallbacks.onScrollChanged();
        }
    }

    @Override
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public void setCallbacks(Callbacks listener) {
        mCallbacks = listener;
    }

    public static interface Callbacks {
        public void onScrollChanged();
    }
    
    private Dictionary<Integer, Integer> listViewItemHeights = new Hashtable<Integer, Integer>();

    public int getScroll() {
        View c = getChildAt(0); //this is the first visible row
        int scrollY = -c.getTop();
        listViewItemHeights.put(getFirstVisiblePosition(), c.getHeight());
        for (int i = 0; i < getFirstVisiblePosition(); ++i) {
            if (listViewItemHeights.get(i) != null) // (this is a sanity check)
                scrollY += listViewItemHeights.get(i); //add all heights of the views that are gone
        }
        return scrollY;
    }
    
    public int getViewHeigth(View v) {
        int viewPosition = getPositionForView(v);
        int scrollY = 0;
        for (int i = 0; i < viewPosition; ++i) {
                scrollY += getChildAt(i).getHeight();
        }
        return scrollY;
    }
    
}
