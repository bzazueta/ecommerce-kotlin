package com.monosoft.ecommercebenja.presentation.screens.client.category.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components.AdminCategoryListItem

@Composable
fun ClientCategoryListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    categories:  List<Category>

) {
    //Text(text = "ClientCategoryListContent")
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = categories
        ) {category ->
            ClientCategoryListItem(navController, category)
        }
    }
}
