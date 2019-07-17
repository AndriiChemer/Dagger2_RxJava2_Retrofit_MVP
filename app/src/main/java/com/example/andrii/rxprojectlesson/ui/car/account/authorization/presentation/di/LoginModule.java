package com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.di;

import com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.LoginContract;
import com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.LoginPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {

    @Binds
    abstract LoginContract.Presenter bindLoginPresenter(LoginPresenter presenter);
}
