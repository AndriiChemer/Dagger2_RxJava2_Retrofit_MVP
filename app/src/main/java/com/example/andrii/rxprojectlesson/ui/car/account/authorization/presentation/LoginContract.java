package com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;

public interface LoginContract {

    interface View extends BaseContract.View {

        void openResetPasswordScreen();

        void openAccountScreen();

        void singInUsingFacebook();

        void openRegistrationScreen();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onResetPasswordClick();

        void onLoginButtonClick();

        void onFacebookLoginClick();

        void onRegistrationButtonClick();
    }
}
