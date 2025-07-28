pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidStarter"
include(
    ":app",
    ":core:designsystem",
    ":core:ui",
    ":core:common",
    ":core:network:retrofit",
    ":core:database",
    ":feature:onboarding",
    ":feature:auth",
    ":feature:home",
    ":feature:browse",
    ":feature:thing",
    ":feature:notifications",
    ":feature:profile",
    ":feature:settings",
    ":feature:support"
)