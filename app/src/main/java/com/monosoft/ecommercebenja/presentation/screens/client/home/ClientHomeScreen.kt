package com.monosoft.ecommercebenja.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.monosoft.ecommercebenja.presentation.navigation.graph.client.ClientNavGraph
import com.monosoft.ecommercebenja.presentation.screens.client.home.components.ClientBottomBar

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