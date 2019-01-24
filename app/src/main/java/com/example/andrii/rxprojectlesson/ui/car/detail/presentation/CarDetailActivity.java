package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;

public class CarDetailActivity extends BaseActivity<CarDetailContract.View, CarDetailContract.Presenter> implements CarDetailContract.View {

    private static final String CAR_ID_KEY = "car_id_key";

    public static void start(Context context, Integer idCar) {
        Intent intent = new Intent(context, CarDetailActivity.class);
        intent.putExtra(CAR_ID_KEY, idCar);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.car_detail_activity;
    }
}
