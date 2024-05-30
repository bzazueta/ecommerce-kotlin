package com.monosoft.ecommercebenja.presentation.screens.client.address.create


import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.client.address.create.components.ClientAddressCreateContent
import com.monosoft.ecommercebenja.presentation.screens.client.address.create.components.CreateAddress
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray200


@Composable
fun ClientAddressCreateScreen(navController: NavHostController, vm: ClientAddressCreateViewModel = hiltViewModel()) {

    vm.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva direccion",
                navController = navController,
                upAvailable = true
            )
        },
        contentColor =  Gray200
    ) { paddingValues ->
        ClientAddressCreateContent(paddingValues)
    }
    CreateAddress()
    
}