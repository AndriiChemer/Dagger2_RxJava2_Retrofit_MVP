package com.example.andrii.rxprojectlesson.ui.car.detail.converter;

import com.example.andrii.rxprojectlesson.core.converter.Converter;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;
import com.example.andrii.rxprojectlesson.ui.map.viewmodel.CarDetailMapViewModel;

import javax.inject.Inject;

public class CarDetailMapConverter implements Converter<CarDetailViewModel,CarDetailMapViewModel> {

    @Inject
    public CarDetailMapConverter() {
    }

    @Override
    public CarDetailMapViewModel convert(CarDetailViewModel car) {
        return new CarDetailMapViewModel(car.getLat(), car.getLng(), car.getBrandModel());
    }
}
