package com.example.andrii.rxprojectlesson.app.di;

import com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.LoginFragment;
import com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.di.LoginModule;
import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.FavoriteFragment;
import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.di.FavoriteModule;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsFragment;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.di.CarsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = CarsModule.class)
    abstract CarsFragment contributeCarsFragment();

    @ContributesAndroidInjector(modules = FavoriteModule.class)
    abstract FavoriteFragment contributeFavoriteFragment();

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginFragment contributeLoginFragment();
}
