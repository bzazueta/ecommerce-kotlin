package com.monosoft.ecommercebenja.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monosoft.ecommercebenja.presentation.screens.profile.info.ProfileViewModel


@Composable
fun DialogDeleteUser(
    state: MutableState<Boolean>,
    idUser: String,
    deleteUser: () ->Unit,
    vm : ProfileViewModel
){


    if (state.value) { // MOSTRAR EL DIALOG
        AlertDialog(  modifier = Modifier
            .fillMaxWidth()
            .height(225.dp),
            containerColor = Color.White,
            onDismissRequest = {state.value=false}, confirmButton = { /*TODO*/ },
            title = { Text(
                text = "Estas seguro de eliminar tu cuenta",
                fontSize = 20.sp,
                color = Color.Black
            )
            },
            dismissButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        modifier = Modifier.width(130.dp).width(50.dp),
                        shape = RectangleShape,
                        onClick = {
                            state.value = false
                        }
                    ) {
                        Text(text = "Cancelar")
                    }
                    Button(
                        modifier = Modifier.width(130.dp),
                        shape = RectangleShape,
                        onClick = {
                            state.value = false
                            vm.deletUser(idUser = idUser)
                            //deleteUser()
                        }
                    ) {
                        Text(text = "Eliminar")
                    }
                }
            }
        )
    }
}