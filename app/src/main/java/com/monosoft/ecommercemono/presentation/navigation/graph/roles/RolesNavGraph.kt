package com.monosoft.ecommercemono.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.monosoft.ecommercemono.presentation.navigation.Graph
import com.monosoft.ecommercemono.presentation.screens.admin.home.AdminHomeScreen
import com.monosoft.ecommercemono.presentation.screens.client.home.ClientHomeScreen
import com.monosoft.ecommercemono.presentation.screens.roles.RolesScreen
import com.monosoft.ecommercemono.presentation.navigation.screen.roles.RolesScreen

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