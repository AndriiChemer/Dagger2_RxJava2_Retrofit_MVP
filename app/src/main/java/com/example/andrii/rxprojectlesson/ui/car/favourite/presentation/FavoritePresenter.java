package com.example.andrii.rxprojectlesson.ui.car.favourite.presentation;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

import javax.inject.Inject;

public class FavoritePresenter
        extends BasePresenter<FavoriteContract.View>
        implements FavoriteContract.Presenter {

    @Inject
    FavoritePresenter() {
    }
}
