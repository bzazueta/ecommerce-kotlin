package com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.monosoft.ecommercebenja.domain.model.PayerCost
import com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentsInstallmentsContent(paddingValues: PaddingValues, installments: List<PayerCost>, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {


    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(20.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = vm.selectedInstallment?.recommendedMessage ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificacion") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = TextFieldDefaults.textFieldColors(
                   // backgroundColor = Color.White
                )
            )

            ExposedDropdownMenu(
                modifier = Modifier.background(Color.White),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                installments.forEachIndexed { index, installment ->
//                    DropdownMenuItem(
//                        onClick = {
//                            vm.selectedInstallment = installment
//                            expanded = false
//                        }
//                    ) {
//                        Text(text = installment.recommendedMessage)
//                    }
                }
            }
        }

    }

}