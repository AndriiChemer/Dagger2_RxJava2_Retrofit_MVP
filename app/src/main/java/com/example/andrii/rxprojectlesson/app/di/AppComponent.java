package com.example.andrii.rxprojectlesson.app.di;

import com.example.andrii.rxprojectlesson.app.Application;
import com.example.andrii.rxprojectlesson.app.modules.APIModule;
import com.example.andrii.rxprojectlesson.app.modules.AppModule;
import com.example.andrii.rxprojectlesson.app.modules.NetworkModule;
import com.example.andrii.rxprojectlesson.app.modules.PreferencesModule;
import com.example.andrii.rxprojectlesson.app.modules.SchedulerModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        SchedulerModule.class,
        APIModule.class,
        PreferencesModule.class
})
public interface AppComponent extends AndroidInjector<Application> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<Application> {
        public abstract Builder network(NetworkModule networkModule);
    }
}
