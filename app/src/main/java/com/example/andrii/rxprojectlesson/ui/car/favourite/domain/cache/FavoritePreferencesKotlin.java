package com.example.andrii.rxprojectlesson.ui.car.favourite.domain.cache;

import com.example.andrii.rxprojectlesson.core.data.BasePreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.securepreferences.SecurePreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FavoritePreferencesKotlin extends BasePreferences {

    private static final String DEFAULT_VALUE = "";
    private static final String FAVORITE_CARS_ID_KEY = "favorite_cars_id_key";

    @Inject
    public FavoritePreferencesKotlin(SecurePreferences securePreferences, Gson gson) {
        super(securePreferences, gson);
    }

    public List<Integer> getFavoritesCarsIds() {
        String json = getStringFromPrefs(FAVORITE_CARS_ID_KEY, DEFAULT_VALUE);
        Type type = new TypeToken<List<String>>() {
        }.getType();
        if (!DEFAULT_VALUE.equals(json)) {
            return getGson().fromJson(json, type);
        } else {
            return new ArrayList<>();
        }
    }

    private boolean putFavoriteCarIds(List<Integer> offersIdList) {
        return putStringToPrefs(FAVORITE_CARS_ID_KEY, getGson().toJson(offersIdList));
    }

    public boolean removeCarId(Integer carId) {
        List<Integer> favoriteIdList = getFavoritesCarsIds();
        if (favoriteIdList.contains(carId)) {
            favoriteIdList.remove(carId);
            return putFavoriteCarIds(favoriteIdList);
        } else {
            return false;
        }
    }

    public boolean addCarId(Integer carId) {
        List<Integer> favoriteIdList = getFavoritesCarsIds();
        if (!favoriteIdList.contains(carId)) {
            favoriteIdList.add(carId);
            return putFavoriteCarIds(favoriteIdList);
        } else {
            return false;
        }
    }
}
