package com.example.andrii.rxprojectlesson.ui.car.list.presentation;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.rx.SimpleCompletableObserver;
import com.example.andrii.rxprojectlesson.core.rx.SimpleSingleObserver;
import com.example.andrii.rxprojectlesson.ui.car.list.converter.CarConverter;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.usecase.AddCarIdToFavoriteUseCase;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.usecase.GetCarsUseCase;

import java.util.List;

import javax.inject.Inject;

public class CarsPresenter
        extends BasePresenter<CarsContract.View>
        implements CarsContract.Presenter {

    private final GetCarsUseCase getCarsUseCase;
    private final AddCarIdToFavoriteUseCase addCarFavoriteUseCase;
    private final CarConverter carConverter;

    @Inject
    CarsPresenter(GetCarsUseCase getCarsUseCase, AddCarIdToFavoriteUseCase addCarFavoriteUseCase, CarConverter carConverter) {
        this.getCarsUseCase = getCarsUseCase;
        this.addCarFavoriteUseCase = addCarFavoriteUseCase;
        this.carConverter = carConverter;
    }

    @Override
    protected void onViewAttach() {
        getCarsList();
    }

    private void getCarsList() {
        getCarsUseCase.executeDelay(3000, new SimpleSingleObserver<List<CarResponse>>(this) {
            @Override
            public void onSuccess(List<CarResponse> carResponses) {
                doOnView(CarsContract.View::hideRecyclerSkeletonView);
            }

            @Override
            public void onError(Throwable e) {
                doOnView(view -> {
                    view.hideRecyclerSkeletonView();
                    view.showDefaultErrorMessage();
                });
            }
        });
    }

    @Override
    public void onItemAdapterClick(int id) {
        doOnView(view -> view.openCarDetailScreen(id));
    }

    @Override
    public void onArrowBackClick() {
        doOnView(CarsContract.View::finishCurrentActivity);
    }

    @Override
    public void onFavoriteButtonClick(int carId, boolean isFavorite) {
        if (isFavorite) {
            addToFavorite(carId);
        } else {
            removeFromFavorite(carId);
        }
    }

    private void addToFavorite(int carId) {
        addCarFavoriteUseCase.execute(carId, new SimpleCompletableObserver(this) {
            @Override
            public void onComplete() {
                int stringRes = R.string.app_name;
                doOnView(view -> view.showPositiveFavoriteMessage(stringRes));
            }

            @Override
            public void onError(Throwable e) {
                doOnView(CarsContract.View::showNegativeFavoriteMessage);
            }
        });
    }

    private void removeFromFavorite(int carId) {

    }
}
