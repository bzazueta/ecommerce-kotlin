package com.monosoft.ecommercebenja.presentation.navigation.screens.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList: AdminScreen(
        route = "admin/category/list",
        title = "Categorias",
        icon = Icons.Default.ExitToApp
    )
//    object ProductList: AdminScreen(
//        route = "admin/products/list",
//        title = "Productos",
//        icon = Icons.Default.ShoppingCart
//    )
    object OrderList: AdminScreen(
        route = "admin/order/list",
        title = "Pedidos",
        icon = Icons.Default.Menu
    )

    object Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}

