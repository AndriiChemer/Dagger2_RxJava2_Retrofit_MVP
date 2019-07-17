package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.model;

import android.widget.ListAdapter;

import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;

import lombok.Value;

@Value
public class CardDetail implements ListItem {

    private String image;
    private String title;
    private String description;
    private String footerDescription;

    @Override
    public int getViewType() {
        return 0;
    }
}
