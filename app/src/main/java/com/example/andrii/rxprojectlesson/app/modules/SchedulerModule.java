package com.example.andrii.rxprojectlesson.app.modules;

import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;
import com.example.andrii.rxprojectlesson.core.scheduler.StandardSchedulerProvider;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SchedulerModule {

    @Binds
    abstract SchedulerProvider provideSchedulerProvider(StandardSchedulerProvider provider);
}
