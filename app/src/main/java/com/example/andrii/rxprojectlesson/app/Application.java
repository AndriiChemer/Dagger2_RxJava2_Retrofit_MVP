package com.example.andrii.rxprojectlesson.app;


import com.example.andrii.rxprojectlesson.app.di.DaggerAppComponent;
import com.example.andrii.rxprojectlesson.app.modules.NetworkModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class Application extends DaggerApplication {

    private static final String SERVER_URL = "https://cars-2f419.firebaseio.com/";

    @Override
    protected AndroidInjector<? extends Application> applicationInjector() {
        return DaggerAppComponent
                .builder()
                .network(new NetworkModule(SERVER_URL))
                .create(this);
    }
}
