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
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class OnboardingViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: OnboardingViewModel
    private lateinit var firstRunRepository: FirstRunRepository

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
    fun `onGetStartedClick sets first run to false`() = runTest {
        viewModel.onGetStartedClick()
        verify(firstRunRepository).setFirstRun(false)
    }
}
