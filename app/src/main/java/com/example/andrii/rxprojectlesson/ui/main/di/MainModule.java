package com.example.andrii.rxprojectlesson.ui.main.di;

import com.example.andrii.rxprojectlesson.ui.main.MainContract;
import com.example.andrii.rxprojectlesson.ui.main.MainPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {
    @Binds
    abstract MainContract.Presenter providePresenter(MainPresenter presenter);
}
