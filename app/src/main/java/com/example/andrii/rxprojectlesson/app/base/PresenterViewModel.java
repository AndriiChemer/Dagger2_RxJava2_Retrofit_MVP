package com.example.andrii.rxprojectlesson.app.base;

import android.arch.lifecycle.ViewModel;

public class PresenterViewModel<V extends BaseContract.View, P extends BaseContract.Presenter>
        extends ViewModel{

    private P presenter;

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public boolean hasPresenter(){ return presenter != null; }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter = null;
    }
}
