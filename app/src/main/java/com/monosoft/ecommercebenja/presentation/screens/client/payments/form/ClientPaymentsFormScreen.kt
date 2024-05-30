package com.monosoft.ecommercebenja.presentation.screens.client.payments.form


import com.monosoft.ecommercebenja.presentation.screens.client.payments.form.ClientPaymentsFormViewModel
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommerce.presentation.screens.client.payments.form.components.GetIdentificationTypes
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar

@Composable
fun ClientPaymentsFormScreen(navController: NavHostController, vm: ClientPaymentsFormViewModel = hiltViewModel()) {

    vm.getIdentificationTypes()
//    vm.getInstallments(525413,100000.0 )

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Formulario de pago",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        GetIdentificationTypes(paddingValues = paddingValues, navController = navController)
    }
    
}