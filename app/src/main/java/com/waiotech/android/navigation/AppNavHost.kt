package com.waiotech.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.waiotech.android.core.common.FirstRunRepository
import com.waiotech.android.core.ui.HomeScreen
import com.waiotech.android.feature.onboarding.OnboardingScreen
import com.waiotech.android.feature.onboarding.OnboardingViewModel

/**
 * Main navigation host for the application.
 *
 * This composable sets up the navigation graph and handles transitions between
 * different screens. It manages the app's navigation state and ensures proper
 * dependency injection for screen-specific ViewModels.
 *
 * @param startDestination The initial destination route (either onboarding or home)
 * @param firstRunRepository Repository for managing first-run state
 * @param modifier Optional modifier for styling
 */
@Composable
fun AppNavHost(
    startDestination: String,
    firstRunRepository: FirstRunRepository,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(Routes.ONBOARDING) {
            val viewModel: OnboardingViewModel =
                viewModel(
                    factory = OnboardingViewModel.provideFactory(firstRunRepository),
                )
            OnboardingScreen(
                viewModel = viewModel,
                onGetStarted = {
                    navController.navigate(Routes.HOME) {
                        // Clear onboarding from back stack to prevent returning to it
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                    }
                },
            )
        }

        composable(Routes.HOME) {
            HomeScreen()
        }
    }
}
