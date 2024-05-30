package com.monosoft.ecommercebenja.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ClientCategoryScreen
import com.monosoft.ecommercebenja.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.monosoft.ecommercebenja.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen


fun NavGraphBuilder.ClientCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProductList.route
    ) {

        composable(
            route = ClientCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                ClientProductByCategoryListScreen(navController, it)
            }
        }

        composable(
            route = ClientCategoryScreen.ProductDetail.route,
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