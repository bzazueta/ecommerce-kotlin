package com.monosoft.ecommercebenja.presentation.screens.client.products.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.presentation.components.ProgressBar
import com.monosoft.ecommercebenja.presentation.screens.client.products.list.ClientProductListViewModel

@Composable
fun GetProducts(navController: NavHostController, paddingValues: PaddingValues, vm: ClientProductListViewModel = hiltViewModel()) {
    when(val response = vm.productsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientProductListContent(navController = navController, paddingValues = paddingValues , products = response.data)
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