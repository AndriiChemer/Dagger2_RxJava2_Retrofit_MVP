package com.example.andrii.rxprojectlesson.ui.main;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;

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

    @Override
    public void onCarListButtonClick() {
        doOnView(MainContract.View::openCarListScreen);
    }

    @Override
    public void onShowCreditCardsClick() {
        doOnView(MainContract.View::openCreditCardsListScreen);
    }

    @Override
    public void onShowCustomRecyclerCreditCardsClick() {
        doOnView(MainContract.View::openCustomRecyclerScreen);
    }

    @Override
    public void onCanvasFirstLessonClick() {
        doOnView(MainContract.View::openCanvasFirstLessonScreen);
    }
}
