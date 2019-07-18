package com.example.andrii.rxprojectlesson.api.mock;

import com.example.andrii.rxprojectlesson.api.category.CategoryResponse;

import java.util.Arrays;
import java.util.List;

class CategoryMock {

    static List<CategoryResponse> getCategories() {
        return Arrays.asList(
                new CategoryResponse(1, "Sedan"),
                new CategoryResponse(2, "Coupe"),
                new CategoryResponse(3, "SUV")
        );
    }
}
