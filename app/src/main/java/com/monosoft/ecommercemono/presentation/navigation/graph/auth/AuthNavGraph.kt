package com.monosoft.ecommercemono.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.monosoft.ecommercemono.presentation.navigation.Graph
import com.monosoft.ecommercemono.presentation.screens.auth.login.LoginScreen
import com.monosoft.ecommercemono.presentation.screens.auth.register.RegisterScreen
import com.monosoft.ecommercemono.presentation.navigation.screen.auth.AuthScreen

/*
esta clase sirve para controlar la navegacion entre pantallas del modulo auth

 */

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)//
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController)//
        }
//        composable(route = AuthScreen.Client.route) {
//            ClientHomeScreen(navController)//
//        }
//        composable(route = AuthScreen.Admin.route) {
//            AdminHomeScreen(navController)//
//        }
    }
}