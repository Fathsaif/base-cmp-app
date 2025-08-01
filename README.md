# Base Compose Multiplatform (CMP) App

This is a **base project template** for quickly starting new apps using **Jetpack Compose Multiplatform (CMP)**. It’s especially useful for migrating from native Android/iOS to CMP.

## 🔧 What’s Included

### ✅ Networking Layer
- Uses [Ktor](https://ktor.io/) for API calls
- Configured with basic request/response handling
- Ready to connect with backend out of the box
- Inspired by the implementation in the **Cashi** app

### ✅ Repository Layer (Data Layer)
- Clean abstraction between data sources and business logic
- Each feature can have its own repository
- Ideal for scalable architecture

### ✅ Business Layer (Use Cases)
- Contains example use cases:
  - `SubmitTransactionUseCase`
  - `GetTransactionsUseCase`
- Encourages clean separation of concerns

### ✅ UI Layer
- Built with **Jetpack Compose Multiplatform**
- Includes:
  - Sample `ViewModel` using `kotlinx.coroutines`
  - Basic UI screens as examp
 
## Project Structure
base-cmp-app/
├── shared/             # Shared KMP code
│   ├── network/        # Ktor client setup
│   ├── repository/     # Data sources
│   ├── business/       # Use cases
│   └── presentation/   # UI and ViewModels
├── androidApp/         # Android-specific code
└── iosApp/             # iOS-specific code (if configured)

This template is maintained by @Fathsaif and serves as a foundation for all future CMP-based apps.

## Demo 



https://github.com/user-attachments/assets/12cc46eb-17c4-4ba4-bd67-ff0a20523f6f


