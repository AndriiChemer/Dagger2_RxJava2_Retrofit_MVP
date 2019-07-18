package com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;

public interface LoginContract {

    interface View extends BaseContract.View {

        void openResetPasswordScreen();

        void openAccountScreen();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onResetPasswordClick();

        void onLoginButtonClick();
    }
}
