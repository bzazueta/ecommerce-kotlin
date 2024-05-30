package com.monosoft.ecommercebenja.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.profile.update.components.ProfileUpdateContent
import com.monosoft.ecommercebenja.presentation.screens.profile.update.components.UpdateUser


@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String) {

    Log.d("ProfileUpdateScreen", "Data: $userParam")// mostramos en log

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvailable = true
            )
        }
    ) {paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
    UpdateUser()

}