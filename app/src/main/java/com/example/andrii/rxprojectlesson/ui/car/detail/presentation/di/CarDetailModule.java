package com.example.andrii.rxprojectlesson.ui.car.detail.presentation.di;

import android.Manifest;
import android.app.Activity;

import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailActivity;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailContract;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailPresenter;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class CarDetailModule {

    @Provides
    CarDetailContract.Presenter bindPresenter(CarDetailPresenter presenter) {
        return presenter;
    }

    @Provides
    Activity provideActivity(CarDetailActivity activity) {
        return activity;
    }

    @Provides
    @Named("Permission")
    String providePhoneCallPermission() {
        return Manifest.permission.CALL_PHONE;
    }
}
