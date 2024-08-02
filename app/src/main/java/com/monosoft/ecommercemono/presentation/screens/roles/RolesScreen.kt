package com.monosoft.ecommercemono.presentation.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navHostController: NavHostController){

    Scaffold {paddingValues ->
        RolesContent(paddingValues, navHostController)

    }
}