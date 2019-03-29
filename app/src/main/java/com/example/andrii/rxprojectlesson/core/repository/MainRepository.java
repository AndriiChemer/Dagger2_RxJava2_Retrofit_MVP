package com.example.andrii.rxprojectlesson.core.repository;

import android.annotation.SuppressLint;

import com.example.andrii.rxprojectlesson.api.API;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.ui.car.favourite.domain.cache.FavoritePreferencesKotlin;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;

public class MainRepository {

    private final API api;
    private final FavoritePreferencesKotlin favoritePreferences;

    @Inject
    public MainRepository(API api, FavoritePreferencesKotlin favoritePreferences) {
        this.api = api;
        this.favoritePreferences = favoritePreferences;
    }

    public Single<List<CarResponse>> getCars() {
        return api.getCars();
    }

    public Single<CarResponse> getCarDetails(Integer carId) {
        return api.getCarDetails(carId);
    }

    public Completable removeCarId(Integer carId) {
        return Single.fromCallable(() ->
                favoritePreferences.removeCarId(carId))
                    .ignoreElement();
    }

    public Completable addCarId(@Nullable Integer carId) {
        return Single.fromCallable(() ->
                favoritePreferences.addCarId(carId))
                .ignoreElement();
    }

    @SuppressLint("CheckResult")
    public Single<List<CarResponse>> getFavoriteCars() {
        return Single.zip(
                getCars(),
                getFavoriteCarsId(),
                (carResponses, carsId) ->
                        Observable.fromIterable(carResponses)
                                .filter(carResponse ->
                                        carsId.contains(carResponse.getId()))
                                .toList()
                                .blockingGet()
        );
    }

    private Single<List<Integer>> getFavoriteCarsId() {
        return Single.fromCallable(favoritePreferences::getFavoritesCarsIds);
    }
}
