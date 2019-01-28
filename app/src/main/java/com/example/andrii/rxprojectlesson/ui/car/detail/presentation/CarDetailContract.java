package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;

public interface CarDetailContract {

    interface View extends BaseContract.View {

        void showCarDetail(CarDetailViewModel carViewModel);

        void showDefaultErrorMessage();

        void showSkeleton();

        void hideSkeletonView();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onCarDataSuccessfullyRetrieved(Integer carId);
    }
}
