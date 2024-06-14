package com.monosoft.ecommercebenja.presentation.screens.admin.order.list


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.compose.material3.Scaffold
import com.monosoft.ecommercebenja.presentation.screens.admin.order.list.components.GetOrders

@Composable
fun AdminOrderListScreen(navController: NavHostController, vm: AdminOrderListViewModel = hiltViewModel()) {

    //vm.getOrders()

    Scaffold() { paddingValues ->  
       GetOrders(navController = navController, paddingValues = paddingValues)
    }
    
}