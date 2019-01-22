package com.example.andrii.rxprojectlesson.ui.car.list.presentation;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.rx.SimpleSingleObserver;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.CarConverter;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.GetCarsUseCase;

import java.util.List;

import javax.inject.Inject;

public class CarsPresenter
        extends BasePresenter<CarsContract.View>
        implements CarsContract.Presenter {

    private final GetCarsUseCase getCarsUseCase;
    private final CarConverter carConverter;

    @Inject
    CarsPresenter(GetCarsUseCase getCarsUseCase, CarConverter carConverter) {
        this.getCarsUseCase = getCarsUseCase;
        this.carConverter = carConverter;
    }

    @Override
    protected void onViewAttach() {
        getCarsList();
    }

    private void getCarsList() {
        getCarsUseCase.execute(new SimpleSingleObserver<List<CarResponse>>(this) {
            @Override
            public void onSuccess(List<CarResponse> carResponses) {
                doOnView(view -> {
                    view.showCars(carConverter.convert(carResponses));
                    view.hideSkeleton();
                });
            }

            @Override
            public void onError(Throwable e) {
                doOnView(CarsContract.View::showDefaultErrorMessage);
            }
        });
    }

    @Override
    public void onItemAdapterClick(int id) {
        doOnView(view -> view.openCarDetailScreen(id));
    }
}
