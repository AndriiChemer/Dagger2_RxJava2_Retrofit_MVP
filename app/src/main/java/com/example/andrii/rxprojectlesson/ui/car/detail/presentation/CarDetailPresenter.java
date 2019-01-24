package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

import javax.inject.Inject;

public class CarDetailPresenter
        extends BasePresenter<CarDetailContract.View>
        implements CarDetailContract.Presenter {

    @Inject
    public CarDetailPresenter() {
    }
}
