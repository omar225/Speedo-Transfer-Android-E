# SpeedoTransfer - Money Transfer Application

## Overview
SpeedoTransfer is a Jetpack Compose-based Android application designed to facilitate seamless money transfers between users. This project demonstrates the core functionalities of user navigation, money transfer flows, and data persistence using shared preferences. Although the backend API integration for actual transfers is planned, it is currently deferred to the next deployment due to time constraints. 

The app includes nested navigation, handles intents, and shows a complete user interface flow from onboarding to transfer completion. Once the backend service is implemented, the app will be fully functional for real-world transfers.

## Features
- **Jetpack Compose UI**: Built with Jetpack Compose for a modern, declarative UI.
- **Nested Navigation**: Features complex navigation with nested flows for onboarding, login, and in-app interactions.
- **Shared Preferences**: User data and session management are handled via shared preferences.
- **Intent Handling**: The app responds to user intents for navigation and data processing.
- **Transfer Flow Simulation**: Demonstrates a simulated money transfer between accounts, showcasing how the app will function with backend support.
- **Scalable Architecture**: The app is structured to support the future integration of API services with minimal adjustments.

## Tech Stack
- **Kotlin**: The primary programming language used for the app.
- **Jetpack Compose**: For building the user interface.
- **MVVM Architecture**: Ensuring separation of concerns and a scalable, maintainable codebase.
- **Retrofit**: For making network requests to the bank's API.
- **Coroutines**: For managing asynchronous tasks efficiently.
- **Shared Preferences**: For lightweight data storage, such as user settings and preferences.
- **DataStore**: A modern, asynchronous storage solution for handling more complex or larger data sets than Shared Preferences.
- **Gson**: For serializing and deserializing JSON data to Kotlin objects.
- **StateFlow**: A state-holder observable flow for managing UI state lifecycle-awarely.


## Future Enhancements
- **Backend API Integration**: The next deployment will include integration with a backend service to manage user accounts and handle real-time money transfers between users.
  
## How to Run the App
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/SpeedoTransfer.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Next Steps
- Implement API service to handle user accounts and money transfers.
- Refine error handling and edge case scenarios for transfer flow.

## Demo
  

https://github.com/user-attachments/assets/84781374-e588-444b-92a9-e3b7821c2412


