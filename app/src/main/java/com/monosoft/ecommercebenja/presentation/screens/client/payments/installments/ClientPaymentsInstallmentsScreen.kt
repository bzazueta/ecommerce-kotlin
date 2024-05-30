package com.monosoft.ecommercebenja.presentation.screens.client.payments.installments

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultButton
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.components.CreateCardToken
import com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.components.CreatePayment
import com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.components.GetInstallments


@Composable
fun ClientPaymentsInstallmentsScreen(navController: NavHostController, paymentFormParam: String, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    Log.d("ClientPaymentsInstallmentsScreen", "Param: ${vm.cardTokenBody}")
    vm.getInstallments(vm.cardTokenBody.cardNumber.substring(0, 6).toInt(), 100000.0)

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Numero de coutas",
            )
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Confirmar transaccion",
                onClick = { vm.createCardToken() }
            )
        }

    ) {paddingValues ->
        GetInstallments(paddingValues = paddingValues)
    }
    CreateCardToken()
    CreatePayment(navController = navController)

}