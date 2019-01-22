package com.example.andrii.rxprojectlesson.app.di;

import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsActivity;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.di.CarsModule;
import com.example.andrii.rxprojectlesson.ui.main.MainActivity;
import com.example.andrii.rxprojectlesson.ui.main.di.MainModule;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationActivity;
import com.example.andrii.rxprojectlesson.ui.registration.di.RegistrationModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = RegistrationModule.class)
    abstract RegistrationActivity bindRegistrationActivity();

    @ContributesAndroidInjector(modules = CarsModule.class)
    abstract CarsActivity bindCarsActivity();
}
