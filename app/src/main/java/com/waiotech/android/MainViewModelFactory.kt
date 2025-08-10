package com.waiotech.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waiotech.android.core.common.FirstRunRepository

/**
 * Factory for creating MainViewModel with required dependencies.
 *
 * This factory injects the FirstRunRepository dependency into MainViewModel,
 * following the dependency injection pattern for ViewModels.
 */
class MainViewModelFactory(
    private val firstRunRepository: FirstRunRepository,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(firstRunRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
}
