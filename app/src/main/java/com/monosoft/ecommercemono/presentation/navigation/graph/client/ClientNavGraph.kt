package com.monosoft.ecommercemono.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.monosoft.ecommercemono.presentation.navigation.Graph
import com.monosoft.ecommercemono.presentation.navigation.screens.client.ClientScreen
import com.monosoft.ecommercemono.presentation.screens.client.category.list.ClientCategoryListScreen
import com.monosoft.ecommercemono.presentation.screens.client.products.list.ClientProductListScreen
import com.monosoft.ecommercemono.presentation.screens.profile.info.ProfileScreen
import com.monosoft.ecommercemono.presentation.navigation.graph.profile.ProfileNavGraph
import com.monosoft.ecommercemono.presentation.screens.client.order.list.ClientOrderListScreen


@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {

        composable(route = ClientScreen.ProductList.route) {
           ClientProductListScreen(navController)
        }

        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen(navController)
        }

        composable(route = ClientScreen.OrderList.route) {
            ClientOrderListScreen(navController)
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }
        //esta clase es el padre de los grafos de navegacion
        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
        ClientProductNavGraph(navController)
        ShoppingBagNavGraph(navController)
        ClientOrderNavGraph(navController)

    }
}