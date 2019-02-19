package com.example.andrii.rxprojectlesson.ui.car.list.viewmodel;

import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsLinearLayoutAdapter;

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
        return CarsLinearLayoutAdapter.CarViewHolder.VIEW_TYPE;
    }
}
