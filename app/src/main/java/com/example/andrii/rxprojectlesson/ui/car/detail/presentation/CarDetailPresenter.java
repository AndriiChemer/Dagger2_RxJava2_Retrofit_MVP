package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.rx.SimpleSingleObserver;
import com.example.andrii.rxprojectlesson.ui.car.detail.converter.CarDetailConverter;
import com.example.andrii.rxprojectlesson.ui.car.detail.converter.CarDetailMapConverter;
import com.example.andrii.rxprojectlesson.ui.car.detail.domain.GetCarDetailUseCase;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;

import javax.inject.Inject;

public class CarDetailPresenter
        extends BasePresenter<CarDetailContract.View>
        implements CarDetailContract.Presenter {

    private CarDetailViewModel carDetailViewModel;

    private final CarDetailConverter carDetailConverter;
    private final CarDetailMapConverter carDetailMapConverter;
    private final GetCarDetailUseCase getCarDetailUseCase;

    @Inject
    public CarDetailPresenter(CarDetailConverter carDetailConverter, CarDetailMapConverter carDetailMapConverter, GetCarDetailUseCase getCarDetailUseCase) {
        this.carDetailConverter = carDetailConverter;
        this.carDetailMapConverter = carDetailMapConverter;
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
                carDetailViewModel = carDetailConverter.convert(carResponse);
                doOnView(view -> {
                    view.showCarDetail(carDetailViewModel);
                    view.prepareDialog("+48537778445");
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

    @Override
    public void onLocalizationClick() {
        doOnView(view -> view.openMapScreen(carDetailMapConverter.convert(carDetailViewModel)));
    }

    @Override
    public void onCallButtonClick(String phoneNumber) {
        doOnView(view -> {
            if (view.hasCallPhonePermission()){
                view.callPhoneNumber(phoneNumber);
            } else {
                view.requestCallPhonePermission();
            }
        });
    }
}
