package com.example.andrii.rxprojectlesson.ui.car.list.viewmodel;

import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsAdapter;


public class CarHeaderViewModel implements ListItem {
    @Override
    public int getViewType() {
        return CarsAdapter.HeaderViewHolder.HEADER_VIEW_TYPE;
    }
}
