package com.waiotech.android.feature.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Onboarding screen shown to users on their first app launch.
 *
 * This screen introduces users to the app and allows them to proceed to the main app.
 * Once the user taps "Get Started", they won't see this screen again unless they
 * clear app data or reinstall.
 *
 * @param viewModel The ViewModel handling onboarding logic and state
 * @param onGetStarted Callback invoked when user completes onboarding
 */
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    onGetStarted: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome to WAIOTECH",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your journey starts here. Let's build something amazing together!",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                viewModel.onGetStartedClick()
                onGetStarted()
            },
        ) {
            Text("Get Started")
        }
    }
}
