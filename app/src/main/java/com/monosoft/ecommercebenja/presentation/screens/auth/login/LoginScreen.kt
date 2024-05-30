package com.monosoft.ecommercebenja.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.monosoft.ecommercebenja.presentation.Greeting
import com.monosoft.ecommercebenja.presentation.screens.auth.login.components.Login
import com.monosoft.ecommercebenja.presentation.screens.auth.login.components.LoginContent
import com.monosoft.ecommercebenja.presentation.ui.theme.EcommerceBenjaTheme

@Composable
fun LoginScreen (navHostController: NavHostController){

    Scaffold {
         paddingValues ->
        LoginContent(navHostController,paddingValues)
    }
    Login(navController = navHostController)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    EcommerceBenjaTheme {
        LoginScreen(rememberNavController())
    }


}