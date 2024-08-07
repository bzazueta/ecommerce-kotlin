package com.monosoft.ecommercemono.presentation.screens.client.address.list.components


import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.presentation.components.ProgressBar
import com.monosoft.ecommercemono.presentation.screens.client.category.list.ClientAddressListViewModel

@Composable
fun GetAddress(paddingValues: PaddingValues, vm: ClientAddressListViewModel = hiltViewModel()) {
    when(val response = vm.addressResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
           ClientAddressListContent(paddingValues, response.data)
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