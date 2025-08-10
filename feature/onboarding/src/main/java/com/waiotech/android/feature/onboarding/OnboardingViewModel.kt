package com.waiotech.android.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.waiotech.android.core.common.FirstRunRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for the onboarding screen.
 *
 * This ViewModel handles the business logic for the onboarding flow,
 * primarily managing the transition from first-run to normal app usage
 * by updating the first run flag in persistent storage.
 */
class OnboardingViewModel(
    private val firstRunRepository: FirstRunRepository,
) : ViewModel() {
    /**
     * Handles the user's tap on the "Get Started" button.
     *
     * This method marks the onboarding as complete by setting the first run
     * flag to false. This ensures the user won't see onboarding again on
     * subsequent app launches.
     */
    fun onGetStartedClick() {
        viewModelScope.launch {
            firstRunRepository.setFirstRun(false)
        }
    }

    companion object {
        /**
         * Provides a ViewModelProvider.Factory for creating OnboardingViewModel instances.
         *
         * This factory handles dependency injection by providing the required
         * FirstRunRepository to the ViewModel constructor.
         *
         * @param firstRunRepository The repository for managing first run state
         * @return A factory that can create OnboardingViewModel instances
         */
        fun provideFactory(firstRunRepository: FirstRunRepository): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    OnboardingViewModel(firstRunRepository)
                }
            }
    }
}
