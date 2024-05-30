package com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultButton
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ShoppingBagScreen
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray100
import com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel


@Composable
fun ClientShoppingBagBottomBar(navController: NavHostController, vm: ClientShoppingBagViewModel = hiltViewModel()) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray100),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TOTAL",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = vm.total.toString() + "$",
                fontSize = 16.sp
            )
        }

        DefaultButton(
            modifier = Modifier
                .padding(vertical = 15.dp),
            text = "Confirmar orden",
            onClick = { navController.navigate(route = ShoppingBagScreen.AddressList.route) }
        )
    }

}