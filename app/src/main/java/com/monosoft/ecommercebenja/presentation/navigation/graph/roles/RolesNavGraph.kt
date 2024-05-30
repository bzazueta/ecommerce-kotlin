package com.monosoft.ecommercebenja.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.screens.admin.home.AdminHomeScreen
import com.monosoft.ecommercebenja.presentation.screens.client.home.ClientHomeScreen
import com.monosoft.ecommercebenja.presentation.screens.roles.RolesScreen
import com.monosoft.ecommercebenja.presentation.navigation.screen.auth.AuthScreen
import com.monosoft.ecommercebenja.presentation.navigation.screen.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ) {

        composable(route = RolesScreen.Roles.route) {
            RolesScreen(navController)
        }
        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }
        composable(route = Graph.ADMIN) {
            AdminHomeScreen()
        }

    }
}