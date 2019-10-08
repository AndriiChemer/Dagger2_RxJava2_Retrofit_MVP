package com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation.RegistrationContract;
import com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation.RegistrationPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RegisterModule {

    @Binds
    abstract RegistrationContract.Presenter bindRegisterPresenter(RegistrationPresenter presenter);
}
