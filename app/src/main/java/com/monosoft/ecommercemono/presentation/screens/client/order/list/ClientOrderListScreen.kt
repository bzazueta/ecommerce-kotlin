package com.monosoft.ecommercemono.presentation.screens.client.order.list


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.screens.client.order.list.components.GetOrders

@Composable
fun ClientOrderListScreen(navController: NavHostController, vm: ClientOrderListViewModel = hiltViewModel()) {

   // vm.getSessionData()

    Scaffold() { paddingValues ->  
        GetOrders(navController = navController, paddingValues = paddingValues)
    }
    
}