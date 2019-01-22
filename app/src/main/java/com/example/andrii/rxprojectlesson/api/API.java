package com.example.andrii.rxprojectlesson.api;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.api.category.CategoryResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface API {

    @GET("/cars")
    Single<List<CarResponse>> getCars();

    @GET("/category")
    Single<List<CategoryResponse>> getCategories();

    @GET("/fuel")
    Single<List<CategoryResponse>> getFuels();
}
