package com.waiotech.android.navigation

/**
 * Navigation route constants for type-safe navigation throughout the app.
 *
 * These constants prevent typos in navigation calls and make refactoring safer.
 * Use these instead of hardcoded strings in NavHost, navigate(), and popUpTo() calls.
 */
object Routes {
    /** Onboarding flow route - shown on first app launch */
    const val ONBOARDING = "onboarding"

    /** Main home screen route - shown after onboarding or on returning launches */
    const val HOME = "home"
}
