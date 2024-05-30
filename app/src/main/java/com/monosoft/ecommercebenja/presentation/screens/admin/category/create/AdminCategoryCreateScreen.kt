package com.monosoft.ecommercebenja.presentation.screens.admin.category.create

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.monosoft.ecommercebenja.presentation.screens.admin.category.create.components.CreateCategory
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray100
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray200


@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva Categoria",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray100, //Card background color opacidad
        contentColor = Gray200
        // backgroundColor = Gray100
    ) { paddingValues ->
        AdminCategoryCreateContent(paddingValues = paddingValues)
    }
   CreateCategory() //llamamos a createcategory

}