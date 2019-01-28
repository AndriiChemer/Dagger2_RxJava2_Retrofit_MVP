package com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel;

import lombok.Value;

@Value
public class CarDetailViewModel {
    private int id;
    private String brandModel;
    private String brand;
    private String model;
    private String description;
    private int price;
    private String photo;
    private String fuel;
    private String localization;
    private String type;
    private double lat;
    private double lng;
    private int cm3;
}
