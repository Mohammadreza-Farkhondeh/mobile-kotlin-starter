package com.waiotech.android.core.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class FirstRunRepository(private val context: Context) {

    private val isFirstRunKey = booleanPreferencesKey("is_first_run")

    val isFirstRun: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[isFirstRunKey] ?: true
        }

    suspend fun setFirstRun(isFirstRun: Boolean) {
        context.dataStore.edit { settings ->
            settings[isFirstRunKey] = isFirstRun
        }
    }
}
