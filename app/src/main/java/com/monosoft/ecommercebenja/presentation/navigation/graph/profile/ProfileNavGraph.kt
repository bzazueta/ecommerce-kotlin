package com.monosoft.ecommercebenja.presentation.navigation.graph.profile

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screen.profile.ProfileScreen
import com.monosoft.ecommercebenja.presentation.screens.profile.update.ProfileUpdateScreen


fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE+ "/{user}", //Graph.PROFILE + "/{user}" se agrega pararecibir valores o argumentos
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {//accedemos a los argumentos
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {//obtenomos los argumentos
                ProfileUpdateScreen(navController, userParam = it)// pasamos los parametros al screen
            }

        }

    }
}