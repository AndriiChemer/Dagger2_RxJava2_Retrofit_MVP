package com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.FavoriteContract;
import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.FavoritePresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FavoriteModule {

    @Binds
    abstract FavoriteContract.Presenter bindPresenter(FavoritePresenter presenter);
}
