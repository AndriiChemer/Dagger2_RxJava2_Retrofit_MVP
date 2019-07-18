package com.example.andrii.rxprojectlesson.api.mock;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.api.car.CarResponse;

import java.util.Arrays;
import java.util.List;

public class CarMock {

    static List<CarResponse> getCarList() {
        return Arrays.asList(
                new CarResponse(1,
                        "Audi",
                        "A4",
                        "Sedan",
                        "The will some description from user.",
                        1,
                        1,
                        1799,
                        51.099923,
                        17.036116,
                        "Benzyna",
                        120000,
                        true,
                        "Wrocław",
                        String.valueOf(R.drawable.audi),
                        false),
                new CarResponse(2,
                        "BMW",
                        "M3",
                        "Sedan",
                        "The will some description from user.",
                        1,
                        1,
                        1799,
                        51.238584,
                        22.537385,
                        "Benzyna",
                        35000,
                        true,
                        "Lublin",
                        String.valueOf(R.drawable.bmw),
                        false),
                new CarResponse(1,
                        "Mercedes-Benz",
                        "CLA",
                        "Sedan",
                        "The will some description from user.",
                        1,
                        1,
                        1799,
                        23.3232,
                        51.1534,
                        "Benzyna",
                        80000,
                        true,
                        "Lublin",
                        String.valueOf(R.drawable.mercedes_benz),
                        false)
        );
    }

    static CarResponse getCarById(Integer id) {
        for (CarResponse car : getCarList()) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return new CarResponse(1,
                "Audi",
                "A4",
                "Sedan",
                "The will some description from user.",
                1,
                1,
                1799,
                51.099923,
                17.036116,
                "Benzyna",
                120000,
                true,
                "Wrocław",
                String.valueOf(R.drawable.audi),
                false);
    }
}
