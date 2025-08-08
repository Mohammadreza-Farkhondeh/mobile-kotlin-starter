package com.waiotech.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waiotech.android.core.common.FirstRunRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    firstRunRepository: FirstRunRepository
) : ViewModel() {

    val startDestination: StateFlow<String> = firstRunRepository.isFirstRun
        .map { isFirstRun ->
            if (isFirstRun) "onboarding" else "home"
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = "onboarding"
        )
}
