package com.monosoft.ecommercebenja.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ClientProductScreen
import com.monosoft.ecommercebenja.presentation.screens.client.product.detail.ClientProductDetailScreen


fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductScreen.ProductDetail.route
    ) {

        composable(
            route = ClientProductScreen.ProductDetail.route,
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {
               ClientProductDetailScreen(navController, it)
            }
        }



    }
}