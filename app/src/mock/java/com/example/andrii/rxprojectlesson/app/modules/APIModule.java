package com.example.andrii.rxprojectlesson.app.modules;

import com.example.andrii.rxprojectlesson.api.API;
import com.example.andrii.rxprojectlesson.api.mock.MockedAPI;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {NetworkModule.class})
public abstract class APIModule {

    @Binds
    abstract API bindAPI(MockedAPI mockedAPI);
}
