package com.monosoft.ecommercebenja.presentation.screens.admin.category.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.admin.AdminCategoryScreen
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components.AdminProductsListContent
import com.monosoft.ecommercebenja.presentation.screens.admin.products.list.components.DeleteProduct
import com.monosoft.ecommercebenja.presentation.screens.admin.products.list.components.GetProducts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminProductsListScreen(navController: NavHostController, categoryParam: String) {

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
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navController.navigate(route = AdminCategoryScreen.ProductCreate.passCategory(categoryParse))
                },
                shape = CircleShape,
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }
    DeleteProduct()

}