plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    // UI components and themes will be added here
    // Will depend on :core:common
}

kotlin {
    jvmToolchain(21)
}
