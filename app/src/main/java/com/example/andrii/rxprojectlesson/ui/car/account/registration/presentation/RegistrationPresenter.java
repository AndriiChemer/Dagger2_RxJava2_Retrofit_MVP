package com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

import javax.inject.Inject;

public class RegistrationPresenter
        extends BasePresenter<RegistrationContract.View>
        implements RegistrationContract.Presenter {

    @Inject
    public RegistrationPresenter() {
    }

    @Override
    public void onLoginButtonClick() {
        doOnView(RegistrationContract.View::openLoginScreen);
    }
}
