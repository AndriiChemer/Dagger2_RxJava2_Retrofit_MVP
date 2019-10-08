package com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;

public interface RegistrationContract {

    interface View extends BaseContract.View {

        void openLoginScreen();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onLoginButtonClick();
    }
}
