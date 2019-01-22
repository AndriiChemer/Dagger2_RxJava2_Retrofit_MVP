package com.example.andrii.rxprojectlesson.ui.car.list.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsContract;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CarsModule {

    @Binds
    abstract CarsContract.Presenter provideCarsScreen(CarsPresenter presenter);
}
