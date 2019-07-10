package com.example.andrii.rxprojectlesson.ui.car.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.presentation.CarContract;
import com.example.andrii.rxprojectlesson.ui.car.presentation.CarPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CarModule {

    @Binds
    abstract CarContract.Presenter bindPresenter(CarPresenter presenter);
}
