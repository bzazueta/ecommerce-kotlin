package com.monosoft.ecommercemono.presentation.screens.client.address.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.components.DefaultButton
import com.monosoft.ecommercemono.presentation.components.DefaultTopBar
import com.monosoft.ecommercemono.presentation.navigation.screens.client.ShoppingBagScreen
import com.monosoft.ecommercemono.presentation.screens.client.address.list.components.GetAddress
import com.monosoft.ecommercemono.presentation.screens.client.category.list.ClientAddressListViewModel

@Composable
fun ClientAddressListScreen(navController: NavHostController, vm: ClientAddressListViewModel = hiltViewModel()) {

   // vm.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mis direcciones",
                navController = navController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 10.dp),
                onClick = {
                    navController.navigate(route = ShoppingBagScreen.AddressCreate.route)
                },
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp).fillMaxWidth(),
                text = "Continuar",
                onClick = { navController.navigate(route = ShoppingBagScreen.PaymentsForm.route) }
            )
        }
    ) { paddingValues ->
        GetAddress(paddingValues)
    }
    
}