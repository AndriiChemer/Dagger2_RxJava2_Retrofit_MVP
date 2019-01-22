package com.example.andrii.rxprojectlesson.app.modules;

import com.example.andrii.rxprojectlesson.api.API;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {NetworkModule.class})
public class APIModule {

    @Provides
    API provideAPI(Retrofit retrofit) {
        return retrofit.create(API.class);
    }
}
