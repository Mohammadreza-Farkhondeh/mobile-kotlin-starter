# Project: WAIOTECH Android App
> Clean-architecture Kotlin/Compose starter for 2025+

## Interaction Protocol
- **Plan → Implement loop**  
  1. Respond in **Plan** mode first (analysis + numbered steps).  
  2. Await explicit **“Approved”** before switching to Implement mode.  
- If the last change fails to compile, reply only with the fixes—no extra commentary.  
- One Git tag per milestone; use **Conventional Commit** style.  

## Toolchain (fixed)
| Item | Version |
|------|---------|
| Gradle Wrapper | **8.13** |
| Android Gradle Plugin | **8.11** |
| Kotlin | **2.0.21** |
| JVM Toolchain | **21** |
| Package name | `com.waiotech.android` |
| SDKs | min 24 · compile 36 · target 36 |

## Module Layout
```

\:core\:common
\:core\:ui
\:core\:network
\:feature\:onboarding
\:feature\:auth
\:feature\:profile
\:feature\:settings
\:feature\:help
\:app

```

## Milestone Changelog

| Tag | What you get |
|-----|--------------|
| **v0.1-skeleton-gradle** | Multi-module Gradle skeleton (nested modules), no Android code yet. |
| **v0.2-compose-hello** | Jetpack Compose enabled; single-activity app shows “Hello, Compose!”. |
| **v0.3-nav-home** | Navigation-Compose wired; `HomeScreen` moved to `:core:ui`. |
| **v0.4-onboarding-module** | `:feature:onboarding`; DataStore flag drives first-run flow. |
| **v0.5-openapi-setup** | `:core:network`, OpenAPI generator task, placeholder `openapi.json`. |
| **v0.6-auth-skeleton** | `:feature:auth`; JWT storage, `AuthInterceptor`, login → home nav. |
| **v0.7-starter-template** | Bottom navigation (Home, Profile, Settings, Help); README & lint clean—ready to publish as generic template. |


## Networking
- OpenAPI spec → `/openapi.json`  
- Generated client lives in `:core:network`, Retrofit + Moshi.  
- `AuthInterceptor` adds `Authorization: Bearer <jwt>`; on 401 triggers refresh.

## Gradle Conventions
- Kotlin DSL everywhere (`*.gradle.kts`).  
- **Version Catalog** (`gradle/libs.versions.toml`).  
- Apply plugins via `alias(libs.plugins.android.application)`.  

## File-Specific Notes
### `:app/src/main/java/com/waiotech/android/MainActivity.kt`
- Keep thin; delegate to `AppNavHost()`.  


