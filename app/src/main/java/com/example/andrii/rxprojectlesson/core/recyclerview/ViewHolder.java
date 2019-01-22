package com.example.andrii.rxprojectlesson.core.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public abstract void bind(T object);
}
