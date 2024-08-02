package com.monosoft.ecommercemono.presentation.screens.client.order.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.presentation.components.ProgressBar
import com.monosoft.ecommercemono.presentation.screens.client.order.list.ClientOrderListViewModel

@Composable
fun GetOrders(navController: NavHostController, paddingValues: PaddingValues, vm: ClientOrderListViewModel = hiltViewModel()) {
    when(val response = vm.ordersResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           ClientOrderListContent(paddingValues, response.data, navController)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}