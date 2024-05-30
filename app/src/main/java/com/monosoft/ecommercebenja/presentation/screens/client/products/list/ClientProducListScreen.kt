package com.monosoft.ecommercebenja.presentation.screens.client.products.list


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.client.products.list.components.GetProducts

@Composable
fun ClientProductListScreen(navController: NavHostController) {


    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "productos",
                enableActions = true,
                navController = navController
            )
        }
    ) {

        paddingValues ->
       GetProducts(navController = navController, paddingValues = paddingValues)
    }

}