package com.example.andrii.rxprojectlesson.app.modules;

import android.content.Context;

import com.example.andrii.rxprojectlesson.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public Context provideContext(Application application) {
        return application;
    }
}
