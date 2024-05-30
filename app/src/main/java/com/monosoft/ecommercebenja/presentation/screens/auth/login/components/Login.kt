package com.monosoft.ecommercebenja.presentation.screens.auth.login.components

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.screens.auth.login.LoginViewModel
import com.monosoft.ecommercebenja.presentation.navigation.screen.auth.AuthScreen
import com.monosoft.ecommercebenja.presentation.navigation.screen.roles.RolesScreen

/**
 *  inyectamos el viemodel vm: LoginViewModel = hiltViewModel()
 */
@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    when(val response = vm.loginResponse) {
        Resource.Loading -> {
            //ProgressBar()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                CircularProgressIndicator()
            }

        }
        is Resource.Success -> {

            LaunchedEffect(Unit) {
//                navController.navigate(route = AuthScreen.Home.route){
//                    popUpTo(AuthScreen.Login.route) { inclusive = true }
//                }
               vm.saveSession(response.data)
                if (response.data.user?.roles!!.size > 1) { // MAS DE UN ROL

                    navController.navigate(route = Graph.ROLES) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                }
                else { // UN SOLO ROL
                    navController.navigate(route = Graph.CLIENT) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                }
            }

        }
        is Resource.Failure -> {//is se agrega si data class
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}