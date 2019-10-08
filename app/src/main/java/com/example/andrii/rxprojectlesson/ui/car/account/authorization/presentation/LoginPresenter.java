package com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter
        extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void onResetPasswordClick() {
        doOnView(LoginContract.View::openResetPasswordScreen);
    }

    @Override
    public void onLoginButtonClick() {
        doOnView(LoginContract.View::openAccountScreen);
    }

    @Override
    public void onFacebookLoginClick() {
        doOnView(LoginContract.View::singInUsingFacebook);
    }

    @Override
    public void onRegistrationButtonClick() {
        doOnView(LoginContract.View::openRegistrationScreen);
    }
}
