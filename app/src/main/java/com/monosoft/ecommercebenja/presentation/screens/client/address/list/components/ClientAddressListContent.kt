package com.monosoft.ecommercebenja.presentation.screens.client.address.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.domain.model.Address


@Composable
fun ClientAddressListContent(paddingValues: PaddingValues, addressList: List<Address>) {
    
    LazyColumn( modifier = Modifier
        .padding(paddingValues = paddingValues)
        .padding(bottom = 55.dp)
        .fillMaxSize()) {
        items(
            items = addressList
        ) {address ->
            ClientAddressListItem(address = address)
        }
    }
    
}