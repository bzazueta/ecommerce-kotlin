package com.monosoft.ecommercemono.presentation.screens.admin.category.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.monosoft.ecommercemono.presentation.components.DefaultButton
import com.monosoft.ecommercemono.presentation.components.DefaultTextField
import com.monosoft.ecommercemono.presentation.components.DialogCapturePicture
import com.monosoft.ecommercemono.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.monosoft.ecommercemono.R
@Composable
fun AdminCategoryCreateContent(paddingValues: PaddingValues, vm: AdminCategoryCreateViewModel = hiltViewModel()) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

      DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
       )

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(40.dp))
       // Text("category content")
        if (!state.image.isNullOrBlank()) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                model = state.image,
                contentDescription = ""
            )
        }
        else {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        stateDialog.value = true
                    },
                painter = painterResource(id = R.drawable.image_add),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(40.dp))//weight(1f)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.8f), //Card background color opacidad
                contentColor = Color.White  //Card content color,e.g.text
            )
        ) {

            Column(
                modifier = Modifier.padding(30.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = {
                         vm.onNameInput(it)
                    },
                    label = "Nombre de la categoria",
                    icon = Icons.Default.List
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = {
                        vm.onDescriptionInput(it)
                    },
                    label = "Descripcion",
                    icon = Icons.Outlined.Info
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Crear categoria",
                    onClick = { vm.createCategory() }
                )
            }

        }

    }
}



