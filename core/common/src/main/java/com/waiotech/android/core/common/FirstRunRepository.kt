package com.waiotech.android.core.common

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "waiotech_settings")

/**
 * Repository for managing first run state using DataStore.
 *
 * This repository handles persistent storage of whether the user has completed
 * the onboarding flow. It uses Jetpack DataStore for type-safe, asynchronous
 * data storage with proper error handling.
 *
 * The first run flag determines whether to show onboarding or go directly
 * to the main app flow.
 */
class FirstRunRepository(
    private val context: Context,
) {
    private companion object {
        private const val TAG = "FirstRunRepository"
        private val IS_FIRST_RUN_KEY = booleanPreferencesKey("is_first_run")
    }

    /**
     * Flow that emits the current first run state.
     *
     * @return Flow<Boolean> where true means this is the first run (show onboarding),
     *         false means onboarding has been completed (go to home)
     */
    val isFirstRun: Flow<Boolean> =
        context.dataStore.data
            .map { preferences ->
                preferences[IS_FIRST_RUN_KEY] ?: true // Default to first run if not set
            }.catch { exception ->
                Log.e(TAG, "Error reading first run state", exception)
                emit(true) // Safe default: show onboarding on error
            }

    /**
     * Updates the first run state.
     *
     * @param isFirstRun true if this should be treated as first run (show onboarding),
     *                   false if onboarding has been completed
     * @throws Exception if the write operation fails
     */
    suspend fun setFirstRun(isFirstRun: Boolean) {
        try {
            context.dataStore.edit { preferences ->
                preferences[IS_FIRST_RUN_KEY] = isFirstRun
            }
            Log.d(TAG, "First run state updated to: $isFirstRun")
        } catch (exception: Exception) {
            Log.e(TAG, "Error setting first run state to: $isFirstRun", exception)
            throw exception
        }
    }
}
