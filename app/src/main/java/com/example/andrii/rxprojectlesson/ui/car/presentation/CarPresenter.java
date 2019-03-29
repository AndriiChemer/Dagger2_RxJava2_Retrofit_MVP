package com.example.andrii.rxprojectlesson.ui.car.presentation;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.rx.SimpleSingleObserver;
import com.example.andrii.rxprojectlesson.ui.car.list.converter.CarConverter;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.usecase.GetCarsUseCase;

import java.util.List;

import javax.inject.Inject;

public class CarPresenter extends BasePresenter<CarContract.View>
        implements CarContract.Presenter  {

    private final GetCarsUseCase getCarsUseCase;
    private final CarConverter carConverter;

    @Inject
    public CarPresenter(GetCarsUseCase getCarsUseCase, CarConverter carConverter) {
        this.getCarsUseCase = getCarsUseCase;
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
                doOnView(view -> {
                    view.showCars(carConverter.convert(carResponses));
//                    view.hideRecyclerSkeletonView();
                });
            }

            @Override
            public void onError(Throwable e) {
                //                    view.hideRecyclerSkeletonView();
                doOnView(CarContract.View::showDefaultErrorMessage);
            }
        });
    }
}
