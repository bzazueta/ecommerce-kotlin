package com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.monosoft.ecommercebenja.domain.model.PayerCost
import com.monosoft.ecommercebenja.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel
import com.monosoft.ecommercebenja.presentation.ui.theme.Blue700


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentsInstallmentsContent(paddingValues: PaddingValues, installments: List<PayerCost>, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {


    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()
        .padding(20.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier
                //.background(Color.White)
                .height(60.dp)
        ) {
            OutlinedTextField(
                readOnly = true,
                value = vm.selectedInstallment?.recommendedMessage ?: "",
                onValueChange = {},
                label = { Text(text = "Tipo de identificacion", color = Blue700) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = outlinedTextFieldColors(
                    focusedBorderColor = Blue700,
                    unfocusedBorderColor = Blue700,

                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                installments.forEach { installment: PayerCost ->
                    DropdownMenuItem(
                        text = { Text(text = installment.recommendedMessage) },
                        onClick = {
                            vm.selectedInstallment = installment
                            expanded = false
                        }
                    )
                }
            }
        }

    }

}
