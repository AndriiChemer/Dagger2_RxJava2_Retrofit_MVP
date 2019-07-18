package com.example.andrii.rxprojectlesson.api.mock;

import com.example.andrii.rxprojectlesson.api.category.CategoryResponse;

import java.util.Arrays;
import java.util.List;

public class FuelMock {

    static List<CategoryResponse> getFuels() {
        return Arrays.asList(
                new CategoryResponse(1, "Benzyna"),
                new CategoryResponse(2, "Diesel")
        );
    }
}
