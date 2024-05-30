package com.monosoft.ecommercebenja.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.screens.client.home.ClientHomeScreen
import com.monosoft.ecommercebenja.presentation.navigation.graph.auth.AuthNavGraph
import com.monosoft.ecommercebenja.presentation.navigation.graph.roles.RolesNavGraph

/*
esta clase sirve para agregar e inicializar las rutas de pantallas
navgraph
 */

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
    }
}