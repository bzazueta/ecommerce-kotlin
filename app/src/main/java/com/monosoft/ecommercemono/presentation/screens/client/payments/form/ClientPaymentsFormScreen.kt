package com.monosoft.ecommercemono.presentation.screens.client.payments.form


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.components.DefaultTopBar

@Composable
fun ClientPaymentsFormScreen(navController: NavHostController, vm: ClientPaymentsFormViewModel = hiltViewModel()) {

    vm.getIdentificationTypes()


    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Formulario de pago",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        //GetIdentificationTypes(paddingValues = paddingValues, navController = navController)
        ClientPaymentsFormContent(
            paddingValues = paddingValues,
            navController = navController,
        )
    }
    
}