package com.example.andrii.rxprojectlesson.app.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class MVPActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends DaggerAppCompatActivity implements BaseContract.View {

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

    protected void prepareView() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
