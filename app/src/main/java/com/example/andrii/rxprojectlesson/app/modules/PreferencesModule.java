package com.example.andrii.rxprojectlesson.app.modules;

import android.content.Context;

import com.securepreferences.SecurePreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    @Singleton
    @Provides
    SecurePreferences provideSecurePreferences(Context context) {
        return new SecurePreferences(context);
    }
}
