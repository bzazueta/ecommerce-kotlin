package com.monosoft.ecommercemono.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.monosoft.ecommercemono.presentation.navigation.graph.admin.AdminNavGraph
import com.monosoft.ecommercemono.presentation.screens.client.home.components.AdminBottomBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        bottomBar = {
            AdminBottomBar(navController = navController)
        }
    )

    {
            paddingValues ->
            AdminNavGraph(navController = navController)
        //Text(modifier = Modifier.padding(paddingValues), text = "adminHomeScreen")

    }
}