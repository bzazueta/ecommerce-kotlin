package com.monosoft.ecommercebenja.presentation.screens.client.payments.form


import com.monosoft.ecommercebenja.presentation.screens.client.payments.form.ClientPaymentsFormViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultButton
import com.monosoft.ecommercebenja.presentation.components.DefaultTextField
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ShoppingBagScreen



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentsFormContent(paddingValues: PaddingValues, navController: NavHostController, identificationTypes: List<String>, vm: ClientPaymentsFormViewModel = hiltViewModel()) {

    val state = vm.state
    var selectedItem by remember { mutableStateOf(identificationTypes[0]) }
    vm.onIdentificationTypeInput(selectedItem)
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)

    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.cardNumber,
            onValueChange = { vm.onCardNumberInput(it) },
            label = "Numero de la tarjeta",
            icon = Icons.Default.Settings,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationYear,
                onValueChange = { vm.onYearExpirationInput(it) },
                label = "Año de expiracion YYYY",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationMonth,
                onValueChange = { vm.onMonthExpirationInput(it) },
                label = "Mes de expiracion MM",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { vm.onNameInput(it) },
            label = "Nombre del titular",
            icon = Icons.Default.Person
        )
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onSecurityCodeInput(it) },
            label = "Codigo de seguridad",
            icon = Icons.Default.Lock
        )
        Spacer(modifier = Modifier.height(10.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificacion") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
//                colors = TextFieldDefaults.textFieldColors(
//                    //backgroundColor =Color.White
//                )

            )

            ExposedDropdownMenu(
                modifier = Modifier.background(Color.White),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                identificationTypes.forEachIndexed { index, identification ->
//                    DropdownMenuItem(
//                        onClick = {
//                            selectedItem = identification
//                            vm.onIdentificationTypeInput(selectedItem)
//                            expanded = false
//                        }
//                    ) {
//                        Text(text = identification)
//                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.number,
            onValueChange = { vm.onIdentificationNumberInput(it) },
            label = "Numero de identificacion",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continuar",
            onClick = {
                navController.navigate(route = ShoppingBagScreen.PaymentsInstallments.passPaymentForm(state.toCardTokenBody().toJson())) {
                    popUpTo(ShoppingBagScreen.PaymentsForm.route) { inclusive = true }
                }
            }
        )

    }
    
}