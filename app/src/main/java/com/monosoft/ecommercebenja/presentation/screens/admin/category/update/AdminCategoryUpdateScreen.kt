package com.monosoft.ecommercebenja.presentation.screens.admin.category.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.monosoft.ecommercebenja.presentation.screens.admin.category.update.components.UpdateCategory
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray200


@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam: String) {

    Log.d("AdminCategoryUpdateScreen", "Data: $categoryParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Categoria",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray200.copy(alpha = 0.8f), //Card background color opacidad
        contentColor = Gray200  //Card content color,e.g.text
    ) { paddingValues ->
        AdminCategoryUpdateContent(paddingValues = paddingValues)
    }
    UpdateCategory()

}