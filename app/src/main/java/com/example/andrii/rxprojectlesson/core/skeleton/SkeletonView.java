package com.example.andrii.rxprojectlesson.core.skeleton;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.example.andrii.rxprojectlesson.core.recyclerview.BaseAdapter;


public class SkeletonView {

    public static ViewSkeletonScreen showSkeleton(View rootView, int layoutResource){
        return Skeleton.bind(rootView)
                .load(layoutResource)
                .duration(500)
                .show();
    }

    public static RecyclerViewSkeletonScreen showSkeleton(RecyclerView recyclerView, BaseAdapter adapter, int itemAdapterResource){
        return Skeleton.bind(recyclerView)
                .adapter(adapter)
                .load(itemAdapterResource)
                .duration(500)
                .frozen(false)
                .show();
    }
}
