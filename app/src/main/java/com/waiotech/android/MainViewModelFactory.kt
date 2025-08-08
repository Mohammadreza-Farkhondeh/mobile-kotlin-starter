package com.waiotech.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waiotech.android.core.common.FirstRunRepository

class MainViewModelFactory(
    private val firstRunRepository: FirstRunRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(firstRunRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
