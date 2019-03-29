package com.example.andrii.rxprojectlesson.core.data;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.securepreferences.SecurePreferences;

public class BasePreferences {

    private SecurePreferences securePreferences;
    private Gson gson;

    public BasePreferences(SecurePreferences securePreferences, Gson gson) {
        this.securePreferences = securePreferences;
        this.gson = gson;
    }

    public Gson getGson() {
        return gson;
    }

    @Nullable
    protected String getStringFromPrefs(String key, String defaultValue) {
        return securePreferences.getString(key, defaultValue);
    }

    protected boolean putStringToPrefs(String key, String value) {
        return securePreferences.edit()
                .putString(key, value)
                .commit();
    }

    protected boolean getBooleanFromPrefs(String key, boolean defaultValue) {
        return securePreferences.getBoolean(key, defaultValue);
    }

    protected void putBooleanToPrefs(String key, boolean value) {
        securePreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    protected int getIntFromPrefs(String key, int defaultValue) {
        return securePreferences.getInt(key, defaultValue);
    }

    protected void putIntToPrefs(String key, int value) {
        securePreferences.edit()
                .putInt(key, value)
                .apply();
    }

    protected boolean removeValue(String key) {
        return securePreferences.edit()
                .remove(key)
                .commit();
    }

    protected boolean containsKey(String key) {
        return securePreferences.contains(key);
    }
}
