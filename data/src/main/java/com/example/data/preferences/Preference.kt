package com.example.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.core.remove
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first

class Preference(context: Context) {
    private var dataStore = context.createDataStore("DataStore")

    suspend fun setUser(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStoreKey.apply {
            dataStore.edit { login ->
                login[dataStoreKey] = value
            }
        }
    }

    suspend fun getUser(key: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preference = dataStore.data.first()
        return preference[dataStoreKey] ?: ""
    }

    suspend fun removeUser(key: String) {
        dataStore.edit {
            it.remove(preferencesKey<String>(key))
        }
    }

    companion object {
        const val USER_KEY = "user_key"
    }
}