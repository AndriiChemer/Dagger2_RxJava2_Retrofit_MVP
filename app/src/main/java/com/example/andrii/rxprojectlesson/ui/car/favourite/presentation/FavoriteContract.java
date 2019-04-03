package com.example.andrii.rxprojectlesson.ui.car.favourite.presentation;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.List;

public interface FavoriteContract {

    interface View extends BaseContract.View {

        void openCarDetailScreen(int id);

        void showDefaultErrorMessage();

        void hideRecyclerSkeletonView();

        void finishCurrentActivity();

        void showPositiveFavoriteMessage(int stringRes);

        void showNegativeFavoriteMessage();

        void removeFromRecycler(int adapterPosition);

        void cleanAdapters();

        void showCars(List<CarViewModel> carList);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void onArrowBackClick();

        void onItemAdapterClick(int carId);

        void onFavoriteButtonClick(int carId, boolean isFavorite, int adapterPosition);

        void onCleanButtonClick();
    }
}
