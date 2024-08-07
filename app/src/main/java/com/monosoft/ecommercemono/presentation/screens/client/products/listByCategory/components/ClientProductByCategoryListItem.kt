package com.monosoft.ecommercemono.presentation.screens.client.product.listByCategory.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.monosoft.ecommercemono.domain.model.Product
import com.monosoft.ecommercemono.presentation.navigation.screens.client.ClientProductScreen
import com.monosoft.ecommercemono.presentation.ui.theme.Gray100
import com.monosoft.ecommercemono.presentation.screens.client.product.listByCategory.ClientProductByCategoryListViewModel


@Composable
fun ClientProductByCategoryListItem(navController: NavHostController, product: Product, vm: ClientProductByCategoryListViewModel = hiltViewModel()) {

    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
            .clickable {
                navController.navigate(
                    route = ClientProductScreen.ProductDetail.passProduct(product.toJson())
                )
            }
    ) {
        Row() {
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.price.toString() + "$",
                    color = Color.Black,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = product.image1,
                contentDescription = ""
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier.padding(end = 80.dp),
            color = Gray100,
        )
    }


}