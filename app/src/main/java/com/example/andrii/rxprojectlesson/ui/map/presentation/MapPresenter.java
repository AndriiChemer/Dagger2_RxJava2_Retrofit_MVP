package com.example.andrii.rxprojectlesson.ui.map.presentation;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

import javax.inject.Inject;

public class MapPresenter
        extends BasePresenter<MapContract.View>
        implements MapContract.Presenter {

    @Inject
    public MapPresenter() {
    }
}
