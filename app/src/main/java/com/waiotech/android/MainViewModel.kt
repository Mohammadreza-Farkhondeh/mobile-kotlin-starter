package com.waiotech.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waiotech.android.core.common.FirstRunRepository
import com.waiotech.android.navigation.Routes
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * MainViewModel handles the app's initial navigation logic based on first run state.
 *
 * This ViewModel determines whether to show onboarding or go directly to home screen
 * based on whether this is the user's first time launching the app.
 *
 * The startDestination is nullable to prevent first-frame flicker - the UI shows
 * a loading state until the destination is determined.
 */
class MainViewModel(
    firstRunRepository: FirstRunRepository,
) : ViewModel() {
    /**
     * Determines the initial navigation destination based on first run state.
     *
     * Returns null initially to prevent flicker, then:
     * - [Routes.ONBOARDING] if this is the first app launch
     * - [Routes.HOME] if the user has already completed onboarding
     */
    val startDestination: StateFlow<String?> =
        firstRunRepository.isFirstRun
            .map { isFirstRun ->
                if (isFirstRun) Routes.ONBOARDING else Routes.HOME
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null, // Prevents first-frame flicker
            )
}
