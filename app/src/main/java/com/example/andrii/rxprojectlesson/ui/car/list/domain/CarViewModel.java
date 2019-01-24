package com.example.andrii.rxprojectlesson.ui.car.list.domain;

import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsAdapter;

import lombok.Value;

@Value
public class CarViewModel implements ListItem {
    private int id;
    private String brand;
    private String model;
    private int price;
    private String photo;
    private String fuel;
    private String localization;

    @Override
    public int getViewType() {
        return CarsAdapter.CarViewHolder.VIEW_TYPE;
    }
}
