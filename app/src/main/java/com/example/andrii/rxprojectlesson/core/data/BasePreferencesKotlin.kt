package com.example.andrii.rxprojectlesson.core.data

import com.google.gson.Gson
import com.securepreferences.SecurePreferences

open class BasePreferencesKotlin(open val gson: Gson, open val securePreferences: SecurePreferences) {

    protected fun getStringFromPrefs(key: String, defaultValue: String) =
            securePreferences.getString(key, defaultValue)

    protected fun putStringToPrefs(key: String, value: String): Boolean =
            securePreferences.edit()
                    .putString(key, value)
                    .commit()

    protected fun getBooleanFromPrefs(key: String, defaultValue: Boolean) =
            securePreferences.getBoolean(key, defaultValue)

    protected fun putBooleanToPrefs(key: String, value: Boolean): Boolean =
            securePreferences.edit()
                    .putBoolean(key, value)
                    .commit()

    protected fun getIntFromPrefs(key: String, defaultValue: Int) =
            securePreferences.getInt(key, defaultValue)

    protected fun putIntToPrefs(key: String, value: Int): Boolean =
            securePreferences.edit()
                    .putInt(key, value)
                    .commit()

    protected fun containsKey(key: String) = securePreferences.contains(key)

    protected fun removeKey(key: String) =
            securePreferences.edit()
                    .remove(key)
                    .commit()

}