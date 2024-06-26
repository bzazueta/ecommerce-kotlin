package com.monosoft.ecommercebenja.presentation.screens.admin.products.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.presentation.components.ProgressBar
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.AdminProductsListViewModel

@Composable
fun DeleteProduct(vm: AdminProductsListViewModel = hiltViewModel()) {
    when(val response = vm.productDeleteResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "El producto se elimino correctamente", Toast.LENGTH_LONG).show()
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