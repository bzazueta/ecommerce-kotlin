package com.monosoft.ecommercebenja.presentation.navigation.graph.admin

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.admin.AdminCategoryScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.AdminProductsListScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.products.create.AdminProductCreateScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.product.update.AdminProductUpdateScreen


fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ) {

        composable(route = AdminCategoryScreen.CategoryCreate.route) {
            AdminCategoryCreateScreen(navController)
        }

        composable(
            route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                AdminCategoryUpdateScreen(navController, it)
            }
        }

        composable(
            route = AdminCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
                AdminProductsListScreen(navController, it)
            }
        }

        composable(
            route = AdminCategoryScreen.ProductCreate.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {
               AdminProductCreateScreen(navController, it)
            }
        }
        composable(
            route = AdminCategoryScreen.ProductUpdate.route,
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {
                AdminProductUpdateScreen(navController, it)
            }
        }

    }
}