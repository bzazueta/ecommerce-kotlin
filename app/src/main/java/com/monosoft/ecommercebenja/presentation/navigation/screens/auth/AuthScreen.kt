package com.monosoft.ecommercebenja.presentation.navigation.screen.auth

sealed class AuthScreen(val route: String) {

    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
    object Home: AuthScreen("home")
    object Client: AuthScreen("client/home")
    object Admin: AuthScreen("admin/home")


}

