package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.rx.SimpleSingleObserver;
import com.example.andrii.rxprojectlesson.ui.car.detail.converter.CarDetailConverter;
import com.example.andrii.rxprojectlesson.ui.car.detail.domain.GetCarDetailUseCase;

import javax.inject.Inject;

public class CarDetailPresenter
        extends BasePresenter<CarDetailContract.View>
        implements CarDetailContract.Presenter {

    private final CarDetailConverter carDetailConverter;
    private final GetCarDetailUseCase getCarDetailUseCase;

    @Inject
    public CarDetailPresenter(CarDetailConverter carDetailConverter, GetCarDetailUseCase getCarDetailUseCase) {
        this.carDetailConverter = carDetailConverter;
        this.getCarDetailUseCase = getCarDetailUseCase;
    }

    @Override
    protected void onViewAttach() {
        doOnView(CarDetailContract.View::showSkeleton);
    }

    @Override
    public void onCarDataSuccessfullyRetrieved(Integer carId) {
        getCarDetailUseCase.execute(carId, new SimpleSingleObserver<CarResponse>(this) {
            @Override
            public void onSuccess(CarResponse carResponse) {
                doOnView(view -> {
                    view.showCarDetail(carDetailConverter.convert(carResponse));
                    view.hideSkeletonView();
                });
            }

            @Override
            public void onError(Throwable e) {
                doOnView(CarDetailContract.View::showDefaultErrorMessage);
                doOnView(view -> {
                    view.hideSkeletonView();
                    view.showDefaultErrorMessage();
                });
            }
        });
    }
}
