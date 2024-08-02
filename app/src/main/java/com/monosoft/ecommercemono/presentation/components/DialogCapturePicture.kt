package com.monosoft.ecommercemono.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit,
) {

    if (state.value) { // MOSTRAR EL DIALOG
        AlertDialog(  modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            containerColor = Color.White,
            onDismissRequest = {state.value=false}, confirmButton = { /*TODO*/ },
            title = { Text(
                text = "Selecciona una opcion",
                fontSize = 20.sp,
                color = Color.Black
            )},
            dismissButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        modifier = Modifier.width(130.dp),
                        shape = RectangleShape,
                        onClick = {
                            state.value = false
                            pickImage()
                        }
                    ) {
                        Text(text = "Galeria")
                    }
                    Button(
                        modifier = Modifier.width(130.dp),
                        shape = RectangleShape,
                        onClick = {
                            state.value = false
                            takePhoto()
                        }
                    ) {
                        Text(text = "Camara")
                    }
                }
            }
        )
    }

}