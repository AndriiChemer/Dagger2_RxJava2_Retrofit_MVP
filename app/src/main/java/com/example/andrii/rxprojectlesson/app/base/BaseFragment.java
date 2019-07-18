package com.example.andrii.rxprojectlesson.app.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.core.recyclerview.BaseAdapter;

public class BaseFragment <V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends MVPFragment<V, P> {

    private RecyclerViewSkeletonScreen recyclerViewSkeletonScreen;
    private ViewSkeletonScreen viewSkeletonScreen;

    public void showNoImplementedFeatureMessage() {
        Toast.makeText(getContext(), getString(R.string.no_implemented), Toast.LENGTH_SHORT).show();
    }

    public void showDefaultErrorMessage() {
        Toast.makeText(getContext(), getString(R.string.default_error), Toast.LENGTH_SHORT).show();
    }

    public void hideRecyclerSkeletonView() {
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.hide();
        }
    }

    public void hideSkeletonView() {
        viewSkeletonScreen.hide();
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.hide();
        }
    }

    public void showSkeletonView(View rootView, int layoutResource){
        viewSkeletonScreen = Skeleton.bind(rootView)
                .load(layoutResource)
                .duration(500)
                .show();
    }

    public void showRecyclerSkeletonView(RecyclerView recyclerView, BaseAdapter adapter, int itemAdapterResource){
        recyclerViewSkeletonScreen = Skeleton.bind(recyclerView)
                .adapter(adapter)
                .load(itemAdapterResource)
                .duration(500)
                .frozen(false)
                .show();
    }
}
