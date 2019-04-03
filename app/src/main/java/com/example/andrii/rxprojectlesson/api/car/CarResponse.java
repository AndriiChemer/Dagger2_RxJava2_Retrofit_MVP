package com.example.andrii.rxprojectlesson.api.car;

import com.google.gson.annotations.SerializedName;

import lombok.Value;

@Value
public class CarResponse {
    private Integer id;
    private String brand;
    private String model;
    private String category;
    private String description;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("fuel_id")
    private int fuelId;
    @SerializedName("cm_3")
    private int cm3;
    private double lat;
    private double lng;
    private String fuel;
    private int price;
    private boolean auction;
    private String localization;
    private String photo;
    private boolean isFavorite;
}
