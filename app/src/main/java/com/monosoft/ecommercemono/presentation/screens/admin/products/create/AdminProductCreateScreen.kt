package com.monosoft.ecommercemono.presentation.screens.admin.products.create

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.components.DefaultTopBar
import com.monosoft.ecommercemono.presentation.screens.admin.products.create.components.AdminProductCreateContent
import com.monosoft.ecommercemono.presentation.screens.admin.products.create.components.CreateProduct
import com.monosoft.ecommercemono.presentation.ui.theme.Gray100


@Composable
fun AdminProductCreateScreen(navController: NavHostController, categoryParam: String) {

    Log.d("AdminProductListScreen", "Category: ${categoryParam}")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo producto",
                upAvailable = true,
                navController = navController
            )
        },
        contentColor = Gray100
    ) {paddingValues ->
        AdminProductCreateContent(paddingValues = paddingValues)
    }
    CreateProduct()
}