package com.example.andrii.rxprojectlesson.api;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.api.category.CategoryResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("/cars.json")
    Single<List<CarResponse>> getCars();

    @GET("/cars/{carId}.json")
    Single<CarResponse> getCarDetails(@Path("carId") Integer carId);

    @GET("/category")
    Single<List<CategoryResponse>> getCategories();

    @GET("/fuel")
    Single<List<CategoryResponse>> getFuels();
}
