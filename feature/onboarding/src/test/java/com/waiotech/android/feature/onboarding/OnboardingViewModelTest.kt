package com.waiotech.android.feature.onboarding

import com.waiotech.android.core.common.FirstRunRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions

/**
 * Unit tests for OnboardingViewModel.
 *
 * These tests verify that the onboarding flow correctly manages the first run state
 * and properly coordinates with the FirstRunRepository.
 */
@ExperimentalCoroutinesApi
class OnboardingViewModelTest {
    private lateinit var viewModel: OnboardingViewModel
    private lateinit var firstRunRepository: FirstRunRepository

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        firstRunRepository = mock()
        viewModel = OnboardingViewModel(firstRunRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `onGetStartedClick sets first run to false`() =
        runTest {
            // When
            viewModel.onGetStartedClick()
            testDispatcher.scheduler.advanceUntilIdle()

            // Then
            verify(firstRunRepository).setFirstRun(false)
            verifyNoMoreInteractions(firstRunRepository)
        }

    @Test
    fun `viewModel does not interact with repository until onGetStartedClick is called`() {
        // Given - ViewModel is created in setUp()

        // Then - No interactions should have occurred yet
        verifyNoMoreInteractions(firstRunRepository)
    }

    @Test
    fun `multiple onGetStartedClick calls each set first run to false`() =
        runTest {
            // When
            viewModel.onGetStartedClick()
            viewModel.onGetStartedClick()
            testDispatcher.scheduler.advanceUntilIdle()

            // Then
            verify(firstRunRepository, times(2)).setFirstRun(false)
        }
}
