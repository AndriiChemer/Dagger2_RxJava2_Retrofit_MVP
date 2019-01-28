package com.example.andrii.rxprojectlesson.app.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.core.recyclerview.BaseAdapter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends DaggerAppCompatActivity
        implements BaseContract.View {

    protected abstract int getLayoutResourceID();

    private RecyclerViewSkeletonScreen recyclerViewSkeletonScreen;
    private ViewSkeletonScreen viewSkeletonScreen;

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceID());
        ButterKnife.bind(this);
        preparePresenter();
        prepareView();
    }

    @SuppressWarnings("unchecked")
    protected void preparePresenter() {
        PresenterViewModel<V, P> presenterViewModel = ViewModelProviders.of(this).get(PresenterViewModel.class);

        if (presenterViewModel.hasPresenter()) {
            presenter = presenterViewModel.getPresenter();
        } else {
            presenterViewModel.setPresenter(presenter);
        }

        presenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected void prepareView() {}

    public void showNoImplementedFeatureMessage() {
        Toast.makeText(this, getString(R.string.no_implemented), Toast.LENGTH_SHORT).show();
    }

    public void showDefaultErrorMessage() {
        Toast.makeText(this, getString(R.string.default_error), Toast.LENGTH_SHORT).show();
    }

    protected String getStringFromExtra(String key) {
        String stringValue = getIntent().getStringExtra(key);
        if (stringValue != null) {
            return stringValue;
        } else {
            throw new IllegalArgumentException(String.format("Value from %s should not be null", key));
        }
    }

    protected Integer getIntegerFromExtra(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            return bundle.getInt(key);
        } else {
            throw new IllegalArgumentException(String.format("Value from %s should not be null", key));
        }
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

    public void showSkeletonView(RecyclerView recyclerView, BaseAdapter adapter, int itemAdapterResource){
        recyclerViewSkeletonScreen = Skeleton.bind(recyclerView)
                .adapter(adapter)
                .load(itemAdapterResource)
                .duration(500)
                .frozen(false)
                .show();
    }
}
