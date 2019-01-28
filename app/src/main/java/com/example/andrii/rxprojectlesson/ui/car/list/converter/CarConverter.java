package com.example.andrii.rxprojectlesson.ui.car.list.converter;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.core.converter.Converter;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarConverter implements Converter<List<CarResponse>, List<CarViewModel>> {

    @Inject
    public CarConverter() {
    }


    @Override
    public List<CarViewModel> convert(List<CarResponse> carsResponse) {
        List<CarViewModel> carViewModelList = new ArrayList<>();
        for (CarResponse carResponse : carsResponse) {
            carViewModelList.add(convertItem(carResponse));
        }
        return carViewModelList;
    }

    private CarViewModel convertItem(CarResponse carResponse) {
        return new CarViewModel(
                carResponse.getId(),
                carResponse.getBrand(),
                carResponse.getModel(),
                carResponse.getPrice(),
                carResponse.getPhoto(),
                carResponse.getFuel(),
                carResponse.getLocalimodelzation());
    }
}
