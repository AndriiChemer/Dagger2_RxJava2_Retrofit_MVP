package com.example.andrii.rxprojectlesson.app.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class MVPFragment<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends DaggerFragment implements BaseContract.View {

    @Inject
    protected P presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        prepareView();
        preparePresenter();
    }

    private void prepareView() {

    }

    @SuppressWarnings("unchecked")
    private void preparePresenter() {
        PresenterViewModel<V, P> presenterViewModel = ViewModelProviders.of(this).get(PresenterViewModel.class);

        if (presenterViewModel.hasPresenter()) {
            presenter = presenterViewModel.getPresenter();
        } else {
            presenterViewModel.setPresenter(presenter);
        }

        presenter.attachView((V) this);
    }

    public P presenter() { return  presenter; }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
