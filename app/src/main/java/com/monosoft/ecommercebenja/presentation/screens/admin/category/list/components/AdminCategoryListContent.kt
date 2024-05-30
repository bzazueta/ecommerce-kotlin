package com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.model.Category

@Composable
fun AdminCategoryListContent( navHostController: NavHostController,categories: List<Category>,paddingValues: PaddingValues) {//categories: List<Category>,

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        items(
            items = categories
        ) {category ->
            AdminCategoryListItem(navHostController, category)
        }
    }
}