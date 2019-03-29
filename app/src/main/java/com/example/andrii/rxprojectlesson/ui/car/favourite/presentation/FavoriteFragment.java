package com.example.andrii.rxprojectlesson.ui.car.favourite.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ClickableFragment;

public class FavoriteFragment
        extends ClickableFragment<FavoriteContract.View, FavoriteContract.Presenter, FavoriteFragment.FavoriteClickListener>
        implements FavoriteContract.View{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cars_fragment, container, false);
    }

    interface FavoriteClickListener {

    }
}
