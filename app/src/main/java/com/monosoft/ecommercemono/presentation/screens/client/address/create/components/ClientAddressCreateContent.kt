package com.monosoft.ecommercemono.presentation.screens.client.address.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.monosoft.ecommercemono.presentation.components.DefaultButton
import com.monosoft.ecommercemono.presentation.components.DefaultTextField
import com.monosoft.ecommercemono.presentation.screens.client.address.create.ClientAddressCreateViewModel
import com.monosoft.ecommercemono.R

@Composable
fun ClientAddressCreateContent(paddingValues: PaddingValues, vm: ClientAddressCreateViewModel = hiltViewModel()) {

    val state = vm.state

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.map),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White, //Card background color opacidad
                //contentColor = Color.White  //Card content color,e.g.text
            )
        ) {

            Column(
                modifier = Modifier.padding(30.dp)
            ) {

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.address,
                    onValueChange = { vm.onAddressInput(it) },
                    label = "Direccion",
                    icon = Icons.Default.LocationOn
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.neighborhood,
                    onValueChange = { vm.onNeighborhoodInput(it) },
                    label = "Barrio",
                    icon = Icons.Default.Info
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Crear direccion",
                    onClick = { vm.createAddress() }
                )
            }

        }

    }
    
}