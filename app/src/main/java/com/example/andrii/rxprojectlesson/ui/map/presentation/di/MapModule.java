package com.example.andrii.rxprojectlesson.ui.map.presentation.di;

import com.example.andrii.rxprojectlesson.ui.map.presentation.MapContract;
import com.example.andrii.rxprojectlesson.ui.map.presentation.MapPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MapModule {

    @Binds
    abstract MapContract.Presenter bindPresenter(MapPresenter presenter);
}
