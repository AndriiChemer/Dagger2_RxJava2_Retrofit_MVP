package com.example.andrii.rxprojectlesson.ui.car.list.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.List;

public interface CarsContract {

    interface View extends BaseContract.View {

        void openCarDetailScreen(int id);

        void showDefaultErrorMessage();

        void hideRecyclerSkeletonView();

        void finishCurrentActivity();

        void showPositiveFavoriteMessage(int stringRes);

        void showNegativeFavoriteMessage();

        void showCars(List<CarViewModel> carList);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onItemAdapterClick(int id);

        void onArrowBackClick();

        void onFavoriteButtonClick(int carId, boolean isFavorite);
    }
}
