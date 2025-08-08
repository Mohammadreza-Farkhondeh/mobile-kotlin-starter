package com.waiotech.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.waiotech.android.core.ui.home.HomeScreen
import com.waiotech.android.feature.onboarding.OnboardingScreen

@Composable
fun AppNavHost(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("onboarding") {
            OnboardingScreen(
                onGetStarted = {
                    navController.navigate("home") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                }
            )
        }
        composable("home") { HomeScreen() }
    }
}
