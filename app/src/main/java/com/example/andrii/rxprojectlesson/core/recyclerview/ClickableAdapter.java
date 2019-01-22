package com.example.andrii.rxprojectlesson.core.recyclerview;

import java.util.List;

public abstract class ClickableAdapter<T extends ListItem, VH extends ViewHolder, L>
        extends BaseAdapter<T, VH>{

    private L listener;

    public L getListener() {
        return listener;
    }

    public void setItems(List<T> items, L listener) {
        this.listener = listener;
        this.getItems().clear();
        this.getItems().addAll(items);

        notifyDataSetChanged();
    }
}
