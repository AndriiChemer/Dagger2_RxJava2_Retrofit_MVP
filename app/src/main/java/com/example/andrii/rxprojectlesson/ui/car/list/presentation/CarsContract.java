package com.example.andrii.rxprojectlesson.ui.car.list.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.CarViewModel;

import java.util.List;

public interface CarsContract {

    interface View extends BaseContract.View {

        void showCars(List<CarViewModel> listCars);

        void openCarDetailScreen(int id);

        void showDefaultErrorMessage();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onItemAdapterClick(int id);
    }
}
