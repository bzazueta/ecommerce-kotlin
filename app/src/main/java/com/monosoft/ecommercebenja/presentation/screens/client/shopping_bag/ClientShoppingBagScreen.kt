package com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar
import com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent


@Composable
fun ClientShoppingBagScreen(navController: NavHostController, vm: ClientShoppingBagViewModel = hiltViewModel()) {

    vm.getShoppingBag()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mi orden",
                upAvailable = true,
                navController = navController
            )
        },
        bottomBar = {
            ClientShoppingBagBottomBar(navController)
        }

    ) { paddingValues ->
        ClientShoppingBagContent(paddingValues, vm.shoppingBag)
    }
}