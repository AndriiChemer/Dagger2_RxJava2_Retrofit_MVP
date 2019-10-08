package com.example.andrii.rxprojectlesson.core.repository;

import com.example.andrii.rxprojectlesson.api.API;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.ui.car.favourite.domain.cache.FavoritePreferencesKotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

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

//    @SuppressLint("CheckResult")
//    public Single<List<CarResponse>> getFavoriteCars() {
//        return Single.zip(
//                getCars(),
//                getFavoriteCarsId(),
//                (carResponses, carsId) ->
//                        Observable.fromIterable(carResponses)
//                                .filter(carResponse ->
//                                        carsId.contains(carResponse.getId()))
//                                .toList()
//                                .blockingGet()
//        );
//    }

//    @SuppressLint("CheckResult")
//    public Single<List<CarResponse>> getFavoriteCars() {
//        return Single.zip(
//                getCars(),
//                getFavoriteCarsId(),
//                (carResponses, carsId) ->
//                        Observable.fromIterable(carResponses)
//                                .filter(new Predicate<CarResponse>() {
//                                    @Override
//                                    public boolean test(CarResponse carResponse) throws Exception {
//                                        for (Integer id : carsId) {
//                                            if (id == carResponse.getId()) {
//                                                return true;
//                                            }
//                                        }
//                                        return false;
//                                    }
//                                })
//                                .toList()
//                                .blockingGet()
//        );
//    }

    public Single<List<CarResponse>> getFavoriteCars() {
        return Single.zip(
                getCars(),
                getFavoriteCarsId(),
                (carResponses, ids) -> {
                    List<CarResponse> favoriteCars = new ArrayList<>();
                    for (int i = 0; i < carResponses.size(); i++) {
                        for (int j = 0; j < ids.size(); j++) {
                            if (ids.get(j).equals(carResponses.get(i).getId())) {
                                favoriteCars.add(carResponses.get(i));
                            }
                        }
                    }
                    return favoriteCars;
                }

        );
    }

    private Single<List<Integer>> getFavoriteCarsId() {
        return Single.fromCallable(favoritePreferences::getFavoritesCarsIds);
    }

    @NotNull
    public Single<Boolean> clearFavorite() {
        return Single.fromCallable(() -> favoritePreferences.putFavoriteCarIds(Collections.emptyList()));
    }
}
