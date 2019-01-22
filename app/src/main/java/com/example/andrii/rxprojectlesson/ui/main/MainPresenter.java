package com.example.andrii.rxprojectlesson.ui.main;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationActivity;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter {

    @Inject
    MainPresenter() {
    }

    @Override
    public void onRegistrationRxValidationButtonClick() {
        doOnView(MainContract.View::openRegistrationScreen);
    }
}
