package com.monosoft.ecommercemono.presentation.screens.client.product.listByCategory

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.presentation.components.DefaultTopBar
import com.monosoft.ecommercemono.presentation.screens.client.product.listByCategory.components.GetProductsByCategory

@Composable
fun ClientProductByCategoryListScreen(navController: NavHostController, categoryParam: String) {
    Log.d("AdminProductListScreen", "Category: ${categoryParam}")
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "Productos",
                     navController = navController,
                     upAvailable = true
                 )
        },
    ) {paddingValues ->
        GetProductsByCategory(navController = navController, paddingValues = paddingValues)
    }
}