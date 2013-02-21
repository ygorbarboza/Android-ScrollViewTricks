Android-ScrollViewTricks
========================

This projects aims to provide a reusable tricks to ScrollView and ListView.

Features
----------

 * Observable scroll in ScrollView and ScrollView.
 * QuickReturn and Sticky animation to any View.
 * Sample of the library.

Building
----

* Select **File, Import, Existing projects into workspace...**
* Select the root folder where you cloned/downloaded the repository to import the project.
* Use **Project - Clean** if there are any errors.

Usage
----------


### ScrollView

#### Layout

``` xml
    <net.appkraft.scrollviewtricks.ObservableScrollView
        android:id="@+id/scroll_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <View style="@style/Item.Top" />

            <View android:id="@+id/placeholder"
                android:layout_width="match_parent"
                android:layout_height="48dp" />

            <View style="@style/Item.Bottom" />
            <View style="@style/Item.Bottom.Alt" />
            <View style="@style/Item.Bottom" />
            <View style="@style/Item.Bottom.Alt" />
            <View style="@style/Item.Bottom" />
            <View style="@style/Item.Bottom.Alt" />

        </LinearLayout>

    </net.appkraft.scrollviewtricks.ObservableScrollView>

    <EditText android:id="@+id/sticky"  
        android:layout_width="match_parent" android:background="#ffffff"
        android:layout_height="48dp" />
```


#### Activity
  
##### StickScrollView

``` java

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
```

##### QuickReturnScrollView

``` java

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
```


### ListView

#### Layout

``` xml
    <net.appkraft.scrollviewtricks.ObservableListView
        android:id="@+id/scroll_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <EditText android:id="@+id/sticky"  
        android:layout_width="match_parent" android:background="#ffffff"
        android:layout_height="48dp" />
```


#### Activity
  
##### StickScrollView

``` java
    mObservableListView = (ObservableListView) rootView
  			.findViewById(R.id.scroll_view);
    mStickyView = rootView.findViewById(R.id.sticky);
    mPlaceholderView = new View(getActivity());
    
    ...
    
    mCallbacks = new StickyListViewCallbacks(mStickyView,
  			mPlaceholderView, mObservableListView);

    mObservableListView.setCallbacks(mCallbacks);
    mObservableListView.addHeaderView(mPlaceholderView);
    
    mObservableListView.getViewTreeObserver().addOnGlobalLayoutListener(
				new StickyListViewGlobalLayoutListener(mStickyView,
						mPlaceholderView, mObservableListView, mCallbacks));
```

##### QuickReturnScrollView

``` java

    mObservableScrollView = (ObservableScrollView) rootView
				.findViewById(R.id.scroll_view);
    mStickyView = rootView.findViewById(R.id.sticky);
    mPlaceholderView = new View(getActivity());
    
    ...

    mCallbacks = new QuickReturnListViewCallbacks(mStickyView,
				mPlaceholderView, mObservableListView);

    mObservableScrollView.setCallbacks(mCallbacks);
    mObservableListView.addHeaderView(mPlaceholderView);

    mObservableListView.getViewTreeObserver().addOnGlobalLayoutListener(
				new QuickReturnListViewGlobalLayoutListener(mStickyView,
						mPlaceholderView, mObservableListView, mCallbacks));
```
