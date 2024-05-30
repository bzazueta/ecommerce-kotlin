package com.monosoft.ecommercebenja.presentation.screens.client.product.listByCategory

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.client.product.listByCategory.components.GetProductsByCategory

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