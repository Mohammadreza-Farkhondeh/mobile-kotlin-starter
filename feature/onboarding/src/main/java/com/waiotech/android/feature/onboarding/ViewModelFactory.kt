package com.waiotech.android.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waiotech.android.core.common.FirstRunRepository

class OnboardingViewModelFactory(
    private val firstRunRepository: FirstRunRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnboardingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OnboardingViewModel(firstRunRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
