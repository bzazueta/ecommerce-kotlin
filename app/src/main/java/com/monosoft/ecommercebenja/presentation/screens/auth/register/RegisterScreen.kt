package com.monosoft.ecommercebenja.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.monosoft.ecommercebenja.presentation.Greeting
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.auth.login.LoginScreen
import com.monosoft.ecommercebenja.presentation.screens.auth.register.components.Register
import com.monosoft.ecommercebenja.presentation.screens.auth.register.components.RegisterContent
import com.monosoft.ecommercebenja.presentation.ui.theme.EcommerceBenjaTheme

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

