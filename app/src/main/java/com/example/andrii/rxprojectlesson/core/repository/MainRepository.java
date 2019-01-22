package com.example.andrii.rxprojectlesson.core.repository;

import com.example.andrii.rxprojectlesson.api.API;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class MainRepository {

    private API api;

    @Inject
    public MainRepository(API api) {
        this.api = api;
    }

    public Single<List<CarResponse>> getCars() {
        return api.getCars();
    }
}
