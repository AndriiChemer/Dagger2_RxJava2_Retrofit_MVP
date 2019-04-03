package com.example.andrii.rxprojectlesson.ui.car.favourite.presentation;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.rx.SimpleCompletableObserver;
import com.example.andrii.rxprojectlesson.core.rx.SimpleSingleObserver;
import com.example.andrii.rxprojectlesson.ui.car.favourite.domain.usecase.GetFavoriteCarsUseCase;
import com.example.andrii.rxprojectlesson.ui.car.favourite.domain.usecase.RemoveAllFavorites;
import com.example.andrii.rxprojectlesson.ui.car.favourite.domain.usecase.RemoveCarFromFavoriteUseCase;
import com.example.andrii.rxprojectlesson.ui.car.list.converter.CarConverter;

import java.util.List;

import javax.inject.Inject;

public class FavoritePresenter
        extends BasePresenter<FavoriteContract.View>
        implements FavoriteContract.Presenter {

    private final CarConverter carConverter;
    private final RemoveAllFavorites removeAllFavoriteCars;
    private final GetFavoriteCarsUseCase getFavoriteCarsUseCase;
    private final RemoveCarFromFavoriteUseCase removeCarFromFavoriteUseCase;

    @Inject
    FavoritePresenter(CarConverter carConverter,
                      RemoveAllFavorites removeAllFavoriteCars,
                      GetFavoriteCarsUseCase getFavoriteCarsUseCase,
                      RemoveCarFromFavoriteUseCase removeCarFromFavoriteUseCase) {
        this.carConverter = carConverter;
        this.removeAllFavoriteCars = removeAllFavoriteCars;
        this.getFavoriteCarsUseCase = getFavoriteCarsUseCase;
        this.removeCarFromFavoriteUseCase = removeCarFromFavoriteUseCase;
    }

    @Override
    protected void onViewAttach() {
        getFavoriteCars();
    }

    private void getFavoriteCars() {
        getFavoriteCarsUseCase.execute(new SimpleSingleObserver<List<CarResponse>>(this) {
            @Override
            public void onSuccess(List<CarResponse> carResponses) {
                doOnView(view -> view.showCars(carConverter.convert(carResponses)));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onArrowBackClick() {
        doOnView(FavoriteContract.View::finishCurrentActivity);
    }

    @Override
    public void onItemAdapterClick(int carId) {
        doOnView(view -> view.openCarDetailScreen(carId));
    }

    @Override
    public void onFavoriteButtonClick(int carId, boolean isFavorite, int adapterPosition) {
        removeCarFromFavoriteUseCase.execute(carId, new SimpleCompletableObserver(this) {
            @Override
            public void onComplete() {
                int stringRes = R.string.app_name;
                doOnView(view -> {
                    view.removeFromRecycler(adapterPosition);
                    view.showPositiveFavoriteMessage(stringRes);
                });
            }

            @Override
            public void onError(Throwable e) {
                doOnView(FavoriteContract.View::showNegativeFavoriteMessage);
            }
        });
    }

    @Override
    public void onCleanButtonClick() {
        removeAllFavoriteCars.execute(new SimpleSingleObserver<Boolean>(this) {
            @Override
            public void onSuccess(Boolean isFavoriteCarsClean) {
                int stringRes = R.string.app_name;
                doOnView(view -> {
                    if (isFavoriteCarsClean) {
                        view.cleanAdapters();
                        view.showPositiveFavoriteMessage(stringRes);
                    } else {
                        doOnView(FavoriteContract.View::showNegativeFavoriteMessage);
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                doOnView(FavoriteContract.View::showNegativeFavoriteMessage);
            }
        });
    }
}
