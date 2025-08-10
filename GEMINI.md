# WAIOTECH Android Starter
> Production-ready Kotlin/Compose starter template for enterprise Android development

## Project Vision
A comprehensive, opinionated starter template that provides a robust foundation for real-world Android applications. Built with clean architecture, modern Android practices, and enterprise-grade patterns.

## Development Protocol

### Interaction Workflow
1. **Plan → Implement Loop**
   - All changes start with **Plan** mode (analysis + numbered implementation steps)
   - Wait for explicit **"Approved"** before switching to **Implement** mode
   - One focused milestone per iteration

2. **Quality Gates**
   - If compilation fails, respond only with fixes—no commentary
   - Each milestone gets a **Git tag** using **Conventional Commit** style
   - Code must pass basic quality checks before tagging

3. **Architecture First**
   - Foundation patterns established early (v0.4-0.6)
   - Feature development follows established patterns (v0.7-0.8)
   - Styling and customization comes last (v0.9)

## Technical Foundation

### Core Technologies (Fixed Versions)
| Component | Version | Purpose |
|-----------|---------|---------|
| **Gradle Wrapper** | 8.13 | Build system |
| **Android Gradle Plugin** | 8.11 | Android tooling |
| **Kotlin** | 2.0.21 | Language & compiler |
| **JVM Toolchain** | 21 | Runtime target |
| **Compose Compiler** | 2.0.21 | UI compiler |

### SDK Configuration
- **Min SDK**: 24 (Android 7.0+, ~94% market coverage)
- **Compile SDK**: 36 (Latest stable APIs)
- **Target SDK**: 36 (Latest behavioral changes)

### Package Structure
```
com.waiotech.android
├── core/
│   ├── common      # Shared utilities, extensions
│   ├── ui          # Design system, shared components
│   └── network     # API clients, networking logic
└── feature/
    ├── onboarding  # First-run experience
    ├── auth        # Authentication flows
    ├── profile     # User profile management
    ├── settings    # App configuration
    └── help        # Support and documentation
```

## Complete Development Roadmap

### **v0.1** - Skeleton Gradle
*Foundation: Multi-module project structure*
- Multi-module Gradle skeleton with nested modules
- Version catalog setup (`gradle/libs.versions.toml`)
- Plugin management and dependency resolution
- Build script conventions (Kotlin DSL)
- **No Android code** - pure Gradle architecture
- Module structure: `:core:*` and `:feature:*` conventions

### **v0.2** - Compose Hello
*Foundation: Basic Compose integration*
- Jetpack Compose enabled in `:app` module
- Single-activity architecture (`MainActivity`)
- Basic "Hello, Compose!" screen rendering
- Material 3 theming integration
- Compose BOM and core dependencies
- **First working Android app** with modern UI toolkit

### **v0.3** - Navigation Home
*Foundation: Navigation infrastructure*
- Navigation-Compose integration
- `AppNavHost` with route management
- `HomeScreen` moved to `:core:ui` module
- Basic navigation between screens
- Compose navigation patterns established
- **Clean navigation architecture** foundation

### **v0.4** - Onboarding Module
*Feature: First-run user experience*
- `:feature:onboarding` module implementation
- DataStore-based `FirstRunRepository` for persistence
- First-run detection and routing logic
- Onboarding → Home navigation flow
- Type-safe route constants (`Routes` object)
- Unit testing for ViewModels and navigation logic
- **Complete onboarding user journey**

### **v0.5** - Production Architecture
*Foundation: Enterprise-grade patterns*
- **Dependency Injection**: Hilt integration or manual DI container
- **Repository Interfaces**: Abstract data layer with concrete implementations
- **UseCase Layer**: Business logic separation from presentation
- **Error Handling**: Sealed `Result<T>` types for operation outcomes
- **State Management**: `UiState` sealed classes for screen states
- **Logging Strategy**: Structured logging with levels (Debug/Info/Error)
- **Testing Infrastructure**: Test doubles, fakes, and integration test setup
- **Performance Optimization**: Memory management, startup time, lifecycle handling
- **Configuration Management**: Build variants, feature flags, environment setup

### **v0.6** - Network & Authentication
*Integration: OpenAPI-driven backend connectivity*
- **OpenAPI Integration**: Code generation from `/openapi.json` specification
- **HTTP Client Stack**: Retrofit + OkHttp + Moshi serialization
- **Authentication Layer**: JWT token storage and refresh handling
- **Network Interceptors**: `AuthInterceptor` for automatic token injection
- **Error Handling**: HTTP error mapping, retry logic, timeout management
- **Offline Support**: Network state detection and caching strategies
- **API Clients**: Generated clients in `:core:network` module
- **Auth Flows**: Login/logout with automatic session management

### **v0.7** - Feature Completeness
*Features: Complete app structure with all core screens*
- **Bottom Navigation**: Home, Profile, Settings, Help tab structure
- **Profile Module**: `:feature:profile` with user data management
- **Settings Module**: `:feature:settings` with app preferences
- **Help Module**: `:feature:help` with support and documentation
- **Navigation Enhancement**: Deep linking, proper back stack management
- **State Preservation**: Screen state across configuration changes
- **User Experience**: Smooth transitions, loading states, error handling
- **Complete App Structure**: All major screens and user flows

### **v0.8** - CRUD Operations
*Features: Data management and real-world patterns*
- **Entity Management**: Full Create, Read, Update, Delete operations
- **List Screens**: Pagination, search, filtering, and sorting capabilities
- **Detail Screens**: Form handling, input validation, state management
- **Data Synchronization**: Online/offline data consistency
- **Optimistic Updates**: Immediate UI feedback with error rollback
- **Real-world Patterns**: Master-detail flows, bulk operations
- **Data Persistence**: Local caching, background sync
- **User Feedback**: Progress indicators, success/error messaging

### **v0.9** - Themeable Design System
*Design: Flexible styling foundation for brand customization*
- **Design Tokens**: Configurable colors, typography, spacing, shapes
- **Component Library**: Reusable, themeable UI component system
- **Theme Support**: Light, dark, and fully custom theme implementations
- **Customization APIs**: Easy brand color and typography overrides
- **Design Documentation**: Component showcase and theming guidelines
- **Brand Flexibility**: Simple adaptation for different project identities
- **Accessibility**: WCAG compliance, contrast ratios, screen reader support
- **Animation System**: Consistent motion design and micro-interactions

### **v1.0** - Production Template
*Release: Complete starter template for enterprise development*
- **Complete Documentation**: Setup guides, architecture decisions, best practices
- **Example Implementation**: Fully functional app with realistic data flows
- **Migration Guides**: Step-by-step adaptation for specific project needs
- **Code Standards**: Established patterns, conventions, and quality gates
- **CI/CD Workflows**: GitHub Actions for testing, building, and deployment
- **Open Source Ready**: License, contributing guidelines, issue templates
- **Performance Benchmarks**: Established metrics and monitoring
- **Template Foundation**: Ready for real-world project customization

---

##  Architecture Principles

### Clean Architecture Layers
```
┌─────────────────┐
│   Presentation  │ ← Compose UI, ViewModels
├─────────────────┤
│   Domain        │ ← UseCases, Domain Models
├─────────────────┤
│   Data          │ ← Repositories, Data Sources
└─────────────────┘
```

### Module Dependencies
```
:app
├── :core:ui (Design system)
├── :core:common (Utilities)
├── :core:network (API clients)
├── :feature:onboarding
├── :feature:auth
├── :feature:profile
├── :feature:settings
└── :feature:help
```

### Key Patterns
- **Single Activity**: MainActivity + Navigation-Compose
- **Repository Pattern**: Interface-based with implementation swapping
- **UseCase Pattern**: Single responsibility business logic
- **State Pattern**: Sealed UiState classes for screen states
- **Result Pattern**: Sealed Result types for error handling
- **Factory Pattern**: ViewModel creation with dependency injection

##  Design Philosophy

### Pre-v0.9 Styling
- **Minimal but Professional**: Clean, readable, functional
- **Material 3**: Follow Material Design guidelines
- **Basic Theming**: Light/dark mode, consistent spacing
- **Focus on Foundation**: Architecture over aesthetics

### v0.9+ Design System
- **Themeable**: Easy customization for different brands
- **Token-based**: Design decisions as configurable parameters
- **Component Library**: Reusable, consistent UI elements
- **Documentation**: Clear usage guidelines and examples

##  Quality Standards

### Testing Strategy
- **Unit Tests**: ViewModels, UseCases, Repositories
- **Integration Tests**: Navigation flows, data operations
- **UI Tests**: Critical user journeys
- **Test Coverage**: Minimum 80% for business logic

### Code Quality
- **Kotlin Style Guide**: Official conventions
- **Static Analysis**: Detekt, Lint, KtLint
- **Architecture Tests**: Enforce module dependencies
- **Code Reviews**: All changes reviewed

### Performance Targets
- **Cold Start**: < 2 seconds to first screen
- **Navigation**: < 16ms frame time (60 FPS)
- **Memory**: No memory leaks, efficient resource usage
- **Network**: Proper caching, offline support

---

## Post-v1.0 Evolution

After v0.9, this project becomes a **template foundation** for real-world applications. Future projects will:

1. **Fork the Template**: Start from v0.9 codebase
2. **Customize Theming**: Apply brand-specific design system
3. **Add Business Logic**: Implement domain-specific features
4. **Extend Architecture**: Add project-specific layers/patterns

The v0.x series focuses on creating the **best possible starting point** for Android development, not a specific application.

---

