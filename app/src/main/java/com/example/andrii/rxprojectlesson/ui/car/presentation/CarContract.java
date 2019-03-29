package com.example.andrii.rxprojectlesson.ui.car.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.List;

public interface CarContract {

    interface View extends BaseContract.View {

        void showCars(List<CarViewModel> carViewModels);

        void showDefaultErrorMessage();
    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}
