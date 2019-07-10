package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.model;

import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;

import lombok.Value;

@Value
public class Card implements ListItem {

    private int resImage;
    private String owner;

    @Override
    public int getViewType() {
        return 0;
    }
}
