package com.example.andrii.rxprojectlesson.ui.car.detail.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailContract;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CarDetailModule {

    @Binds
    abstract CarDetailContract.Presenter bindPresenter(CarDetailPresenter presenter);
}
