package com.monosoft.ecommercemono.presentation.screens.admin.order.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.domain.model.Order


@Composable
fun AdminOrderListContent(paddingValues: PaddingValues, orders: List<Order>, navController: NavHostController) {
    
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(bottom = 55.dp)
            .fillMaxSize()
    ) {
        items(
            items = orders
        ) {order ->
            AdminOrderListItem(order = order, navController = navController)
        }
    }
    
}