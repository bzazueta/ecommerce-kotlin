package com.monosoft.ecommerce.presentation.screens.client.payments.form.components


import com.monosoft.ecommercemono.presentation.screens.client.payments.form.ClientPaymentsFormViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.presentation.components.ProgressBar

@Composable
fun GetIdentificationTypes(paddingValues: PaddingValues, navController: NavHostController, vm: ClientPaymentsFormViewModel = hiltViewModel()) {
    when(val response = vm.identificationTypesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
//           ClientPaymentsFormContent(
//               paddingValues = paddingValues,
//               navController = navController,
//               identificationTypes = response.data.map { identificationType -> identificationType.id }
//           )
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