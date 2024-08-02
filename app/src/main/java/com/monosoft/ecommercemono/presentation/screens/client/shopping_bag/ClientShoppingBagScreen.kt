package com.monosoft.ecommercemono.presentation.screens.client.shopping_bag

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.components.DefaultTopBar
import com.monosoft.ecommercemono.presentation.screens.client.shopping_bag.components.ClientShoppingBagBottomBar
import com.monosoft.ecommercemono.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent


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