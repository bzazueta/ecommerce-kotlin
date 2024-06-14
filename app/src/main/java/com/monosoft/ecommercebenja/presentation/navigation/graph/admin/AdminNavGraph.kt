package com.monosoft.ecommercebenja.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.admin.AdminScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.AdminProductsListScreen
import com.monosoft.ecommercebenja.presentation.screens.profile.info.ProfileScreen
import com.monosoft.ecommercebenja.presentation.navigation.graph.profile.ProfileNavGraph
import com.monosoft.ecommercebenja.presentation.screens.admin.order.list.AdminOrderListScreen

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
