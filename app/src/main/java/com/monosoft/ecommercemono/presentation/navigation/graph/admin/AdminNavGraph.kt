package com.monosoft.ecommercemono.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.monosoft.ecommercemono.presentation.navigation.Graph
import com.monosoft.ecommercemono.presentation.navigation.screens.admin.AdminScreen
import com.monosoft.ecommercemono.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.monosoft.ecommercemono.presentation.screens.profile.info.ProfileScreen
import com.monosoft.ecommercemono.presentation.navigation.graph.profile.ProfileNavGraph
import com.monosoft.ecommercemono.presentation.screens.admin.order.list.AdminOrderListScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.CategoryList.route
    ) {

//        composable(route = AdminScreen.ProductList.route) {
//            AdminProductsListScreen()//navController
//        }


        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen(navController)//
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen(navController)//
        }

        composable(route = AdminScreen.OrderList.route) {
            AdminOrderListScreen(navController)//
        }

        ProfileNavGraph(navController)
        AdminCategoryNavGraph(navController)
        AdminOrderNavGraph(navController)
    }
}
