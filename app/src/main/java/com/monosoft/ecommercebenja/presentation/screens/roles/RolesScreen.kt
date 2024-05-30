package com.monosoft.ecommercebenja.presentation.screens.roles

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navHostController: NavHostController){

    Scaffold {paddingValues ->
        RolesContent(paddingValues, navHostController)

    }
}