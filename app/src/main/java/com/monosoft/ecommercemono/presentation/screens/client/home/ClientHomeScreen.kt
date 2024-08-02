package com.monosoft.ecommercemono.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.monosoft.ecommercemono.presentation.navigation.graph.client.ClientNavGraph
import com.monosoft.ecommercemono.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        //agregamos el bottom bar en el scafold
        bottomBar = {
            ClientBottomBar(navController = navController)
        }
    ) {
        ClientNavGraph(navController = navController)
    }
}