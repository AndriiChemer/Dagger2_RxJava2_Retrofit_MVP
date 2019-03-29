package com.example.andrii.rxprojectlesson.ui.car.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.FavoriteFragment;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsFragment;
import com.example.andrii.rxprojectlesson.ui.car.presentation.CarContract;
import com.example.andrii.rxprojectlesson.ui.car.presentation.CarPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CarModule {

    @Binds
    abstract CarContract.Presenter bindPresenter(CarPresenter presenter);

    @ContributesAndroidInjector
    abstract CarsFragment bindCarsFragment();

    @ContributesAndroidInjector
    abstract FavoriteFragment bindFavoriteFragment();
}
