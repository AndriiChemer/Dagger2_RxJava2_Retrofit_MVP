package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;
import com.example.andrii.rxprojectlesson.ui.map.viewmodel.CarDetailMapViewModel;

public interface CarDetailContract {

    interface View extends BaseContract.View {

        void showCarDetail(CarDetailViewModel carViewModel);

        void showDefaultErrorMessage();

        void showSkeleton();

        void hideSkeletonView();

        void openMapScreen(CarDetailMapViewModel convert);

        boolean hasCallPhonePermission();

        void callPhoneNumber(String phoneNumber);

        void requestCallPhonePermission();

        void prepareDialog(String phoneNumber);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onCarDataSuccessfullyRetrieved(Integer carId);

        void onLocalizationClick();

        void onCallButtonClick(String phoneNumber);
    }
}
