plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    // Common utilities and extensions will be added here
}

kotlin {
    jvmToolchain(21)
}
