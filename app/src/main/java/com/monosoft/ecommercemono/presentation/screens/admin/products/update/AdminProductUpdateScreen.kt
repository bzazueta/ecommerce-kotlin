package com.monosoft.ecommercemono.presentation.screens.admin.product.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.components.DefaultTopBar
import com.monosoft.ecommercemono.presentation.ui.theme.Gray100
import com.monosoft.ecommercemono.presentation.ui.theme.Gray200
import com.monosoft.ecommercemono.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.monosoft.ecommercemono.presentation.screens.admin.product.update.components.UpdateProduct


@Composable
fun AdminProductUpdateScreen(navController: NavHostController, productParam: String) {

    Log.d("AdminProductUpdateScreen", "Category: ${productParam}")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar producto",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray100, //Card background color opacidad
        contentColor = Gray200
    ) {paddingValues ->
        AdminProductUpdateContent(paddingValues = paddingValues)
    }
    UpdateProduct()
}