package com.monosoft.ecommercemono.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.monosoft.ecommercemono.presentation.screens.auth.register.components.Register
import com.monosoft.ecommercemono.presentation.screens.auth.register.components.RegisterContent
import com.monosoft.ecommercemono.presentation.ui.theme.EcommerceBenjaTheme

@Composable
fun RegisterScreen(navController: NavHostController){

    Scaffold(


    ) { paddingValues ->
        RegisterContent(navController,paddingValues)
    }
    Register(navController)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterScreenPreview() {
    EcommerceBenjaTheme {
        RegisterScreen(rememberNavController())
    }
}

