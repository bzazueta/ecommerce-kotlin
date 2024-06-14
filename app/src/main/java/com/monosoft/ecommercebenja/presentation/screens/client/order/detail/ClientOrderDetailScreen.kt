package com.monosoft.ecommercebenja.presentation.screens.client.order.detail

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.admin.order.detail.UpdateStatusOrder
import com.monosoft.ecommercebenja.presentation.screens.client.order.detail.components.ClientOrderDetailContent

@Composable
fun ClientOrderDetailScreen(navController: NavHostController, orderParam: String, vm: ClientOrderDetailViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Detalle de la orden",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->  
        ClientOrderDetailContent(paddingValues, vm.order)
    }
    UpdateStatusOrder()
    
}