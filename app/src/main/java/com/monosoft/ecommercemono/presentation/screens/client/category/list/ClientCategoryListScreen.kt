package com.monosoft.ecommercemono.presentation.screens.client.category.list


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.screens.client.category.list.components.GetCategories

@Composable
fun ClientCategoryListScreen(navController: NavHostController,) {

    Scaffold() {paddingValues ->
        GetCategories(paddingValues, navController)
    }

}