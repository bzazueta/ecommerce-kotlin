package com.monosoft.ecommercemono.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.monosoft.ecommercemono.core.Config
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.presentation.navigation.Graph
import com.monosoft.ecommercemono.presentation.screens.auth.login.LoginViewModel

@Composable
fun Url ( vm: LoginViewModel = hiltViewModel()){

    when(val response = vm.urlResponse) {
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
            if (response.data.size > 0) {
                vm.saveUrl(response.data[0].url)
                //Config.BASE_URL = response.data[0].url
            }
//            LaunchedEffect(Unit) {
////                navController.navigate(route = AuthScreen.Home.route){
////                    popUpTo(AuthScreen.Login.route) { inclusive = true }
////                }
//                vm.saveSession(response.data)
//                if (response.data. { // MAS DE UN ROL
//
////                    navController.navigate(route = Graph.ROLES) {
////                        popUpTo(Graph.AUTH) { inclusive = true }
////                    }
//                }
//                else { // UN SOLO ROL
////                    navController.navigate(route = Graph.CLIENT) {
////                        popUpTo(Graph.AUTH) { inclusive = true }
////                    }
//                }
//            }

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