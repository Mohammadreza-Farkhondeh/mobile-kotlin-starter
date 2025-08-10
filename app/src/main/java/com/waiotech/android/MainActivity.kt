package com.waiotech.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.waiotech.android.core.common.FirstRunRepository
import com.waiotech.android.navigation.AppNavHost
import com.waiotech.android.ui.theme.WaiotechTheme

/**
 * Main entry point of the application.
 *
 * This activity is kept thin and delegates most work to Compose navigation.
 * It handles the initial loading state while determining whether to show
 * onboarding or go directly to the main app flow.
 */
class MainActivity : ComponentActivity() {
    private val firstRunRepository by lazy { FirstRunRepository(this) }

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(firstRunRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WaiotechTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    val startDestination by viewModel.startDestination.collectAsState()

                    startDestination?.let { destination ->
                        AppNavHost(
                            startDestination = destination,
                            firstRunRepository = firstRunRepository,
                            modifier = Modifier.padding(innerPadding),
                        )
                    } ?: run {
                        // Show loading state while determining start destination
                        Box(
                            modifier =
                                Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            contentAlignment = Alignment.Center,
                        ) {
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }
            }
        }
    }
}
