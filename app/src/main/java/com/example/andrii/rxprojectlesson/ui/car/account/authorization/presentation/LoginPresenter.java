package com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter
        extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    @Inject
    public LoginPresenter() {
    }
}
