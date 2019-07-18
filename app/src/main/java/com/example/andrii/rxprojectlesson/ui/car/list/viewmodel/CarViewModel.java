package com.example.andrii.rxprojectlesson.ui.car.list.viewmodel;

import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.adapters.CarsLinearLayoutAdapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarViewModel implements ListItem {
    private int id;
    private String brand;
    private String model;
    private int price;
    private String photo;
    private String fuel;
    private String localization;
    private boolean isFavorite;
    private boolean featured;

    @Override
    public int getViewType() {
        return CarsLinearLayoutAdapter.CarViewHolder.VIEW_TYPE;
    }

    public void setFlagFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
