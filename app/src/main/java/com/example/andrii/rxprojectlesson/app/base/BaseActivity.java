package com.example.andrii.rxprojectlesson.app.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.andrii.rxprojectlesson.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends DaggerAppCompatActivity
        implements BaseContract.View {

    protected abstract int getLayoutResourceID();

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

    protected void showNoImplementedFeatureMessage() {
        Toast.makeText(this, getString(R.string.no_implemented), Toast.LENGTH_SHORT).show();
    }
}
