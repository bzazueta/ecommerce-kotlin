package com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.monosoft.ecommercebenja.presentation.screens.admin.products.list.components.AdminProductListItem
import androidx.compose.foundation.lazy.items
import com.monosoft.ecommercebenja.domain.model.Product

@Composable
fun AdminProductsListContent(navController: NavHostController, paddingValues: PaddingValues, products: List<Product>) {//categories: List<Category>,

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        items(
            items = products) { product ->
            AdminProductListItem(navController, product)
        }
    }
}