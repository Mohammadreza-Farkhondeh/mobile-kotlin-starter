package com.waiotech.android.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waiotech.android.core.common.FirstRunRepository
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val firstRunRepository: FirstRunRepository
) : ViewModel() {

    fun onGetStartedClick() {
        viewModelScope.launch {
            firstRunRepository.setFirstRun(false)
        }
    }
}
