package com.monosoft.ecommercemono.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.R
import com.monosoft.ecommercemono.presentation.components.DefaultButton
import com.monosoft.ecommercemono.presentation.components.DefaultTextField
import com.monosoft.ecommercemono.presentation.screens.auth.login.LoginViewModel
import com.monosoft.ecommercemono.presentation.ui.theme.Black
import com.monosoft.ecommercemono.presentation.ui.theme.Blue500
import com.monosoft.ecommercemono.presentation.navigation.screen.auth.AuthScreen



@OptIn(ExperimentalMaterial3Api::class)
//inyectamos el viewmodel atravez del contrusctos para poder usar sus funciones y estados
@Composable
fun LoginContent(navHostController: NavHostController,paddingValues: PaddingValues,vm : LoginViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current

    //launcheffect nos permite validar o revisar la variable error si a cambiado de estado si a cambiado entra a launcheffect
    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)//toma todos el ancho y alto de la pantalla

    ) {
        val textValueCel = remember {
            mutableStateOf("")
        }

        val textValuePwd = remember {
            mutableStateOf("")
        }

        Image(
            modifier = Modifier.fillMaxSize(),//imagen tamaño completo
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,//se ajusta a toda la pantalla
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo",
                colorFilter = ColorFilter.colorMatrix(
                    ColorMatrix().apply {
                        setToScale(1f,1f,5f,1f)
                    }
                )
            )
            Text(
                modifier = Modifier.padding(top = 7.dp),
                text = "ECOMMERCE APP",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.8f) , //Card background color opacidad
                    contentColor = Color.White  //Card content color,e.g.text
                )
                // backgroundColor = Color.White.copy(alpha = 0.8f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState())
                )
                {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,//recibimos el valos del viewmodel con el estado,
                        onValueChange = { text ->
                            //pasamos el valor al metodo del viewmodel
                            vm.onEmailInput(text)
                        },
                        label = "Correo electronico",
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = { text ->
                            vm.onPasswordInput(text)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Iniciar Sesion",
                        onClick = { vm.login() },
                        color = Blue500
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
//                           modifier = Modifier.padding(end = 6.dp),
                            text = "¿No tienes cuenta?",
                            color = Color(0xFFFFA000),
                            style = TextStyle(
                                fontWeight = FontWeight.Black
                            )
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier.clickable {
                                navHostController.navigate(route = AuthScreen.Register.route)
                            },
                            text = "Registrate",
                            style = TextStyle(
                                fontWeight = FontWeight.Black
                            ),
                            color = Black
                        )
                    }
                }
            }

        }
    }
}