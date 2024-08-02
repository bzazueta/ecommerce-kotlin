package com.monosoft.ecommercemono.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.monosoft.ecommercemono.presentation.navigation.Graph
import com.monosoft.ecommercemono.presentation.navigation.screens.client.ClientOrderScreen
import com.monosoft.ecommercemono.presentation.screens.client.order.detail.ClientOrderDetailScreen

fun NavGraphBuilder.ClientOrderNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_ORDER,
        startDestination = ClientOrderScreen.OrderDetail.route
    ) {

        composable(
            route = ClientOrderScreen.OrderDetail.route,
            arguments = listOf(navArgument("order") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("order")?.let {
                ClientOrderDetailScreen(navController, it)
            }
        }


    }
}