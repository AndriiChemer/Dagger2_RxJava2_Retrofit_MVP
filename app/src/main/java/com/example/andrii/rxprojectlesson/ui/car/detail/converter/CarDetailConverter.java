package com.example.andrii.rxprojectlesson.ui.car.detail.converter;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.core.converter.Converter;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;

import javax.inject.Inject;

public class CarDetailConverter implements Converter<CarResponse, CarDetailViewModel> {

    @Inject
    public CarDetailConverter() {
    }

    @Override
    public CarDetailViewModel convert(CarResponse car) {
        return new CarDetailViewModel(
                car.getId(),
                car.getBrand() + " " + car.getModel(),
                car.getBrand(),
                car.getModel(),
                car.getDescription(),
                car.getPrice(),
                car.getPhoto(),
                car.getFuel(),
                car.getLocalimodelzation(),
                car.getCategory(),
                car.getLat(),
                car.getLng(),
                car.getCm3()
        );
    }
}
