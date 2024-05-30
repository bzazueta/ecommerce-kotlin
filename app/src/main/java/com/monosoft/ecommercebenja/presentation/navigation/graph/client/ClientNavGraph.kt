package com.monosoft.ecommercebenja.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ClientScreen
import com.monosoft.ecommercebenja.presentation.screens.client.category.list.ClientCategoryListScreen
import com.monosoft.ecommercebenja.presentation.screens.client.products.list.ClientProductListScreen
import com.monosoft.ecommercebenja.presentation.screens.profile.info.ProfileScreen
import com.monosoft.ecommercebenja.presentation.navigation.graph.profile.ProfileNavGraph


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
            //ClientOrderListScreen(navController)
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }
        //esta clase es el padre de los grafos de navegacion
        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
        ClientProductNavGraph(navController)
        ShoppingBagNavGraph(navController)
//        ClientOrderNavGraph(navController)

    }
}