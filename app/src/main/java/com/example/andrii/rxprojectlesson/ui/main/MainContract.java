package com.example.andrii.rxprojectlesson.ui.main;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;

public interface MainContract {

    interface View extends BaseContract.View {

        void openRegistrationScreen();

        void openCarListScreen();

        void openCreditCardsListScreen();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onRegistrationRxValidationButtonClick();

        void onCarListButtonClick();

        void onShowCreditCardsClick();
    }
}
