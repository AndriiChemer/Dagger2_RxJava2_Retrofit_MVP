package com.example.andrii.rxprojectlesson.api.mock;

import com.example.andrii.rxprojectlesson.api.API;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.api.category.CategoryResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class MockedAPI implements API {

    @Inject
    public MockedAPI() {
    }

    @Override
    public Single<List<CarResponse>> getCars() {
        return Single.just(CarMock.getCarList());
    }

    @Override
    public Single<CarResponse> getCarDetails(Integer carId) {
        return Single.just(CarMock.getCarById(carId));
    }

    @Override
    public Single<List<CategoryResponse>> getCategories() {
        return Single.just(CategoryMock.getCategories());
    }

    @Override
    public Single<List<CategoryResponse>> getFuels() {
        return Single.just(FuelMock.getFuels());
    }
}
