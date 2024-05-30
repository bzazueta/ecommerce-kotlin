package com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.monosoft.ecommercebenja.R
import com.monosoft.ecommercebenja.domain.model.ShoppingBagProduct
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray100
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray200
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray700
import com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel


@Composable
fun ClientShoppingBagItem(shoppingBagProduct: ShoppingBagProduct, vm: ClientShoppingBagViewModel = hiltViewModel()) {

    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Gray100),
            model = shoppingBagProduct.image1,
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                modifier = Modifier.width(150.dp),
                text = shoppingBagProduct.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(35.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Gray200, //Card background color opacidad
                    //contentColor = Color.White  //Card content color,e.g.text
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )   {
                    Text(
                        modifier = Modifier.clickable { vm.subtractItem(shoppingBagProduct) },
                        text = "-",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = shoppingBagProduct.quantity.toString(),
                        fontSize = 19.sp,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier.clickable { vm.addItem(shoppingBagProduct)  },
                        text = "+",
                        fontSize = 19.sp,
                        color = Color.Black,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = (shoppingBagProduct.price * shoppingBagProduct.quantity).toString())
            Spacer(modifier = Modifier.height(7.dp))
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { vm.deleteItem(shoppingBagProduct.id) },
                painter = painterResource(id = R.drawable.trash),
                contentDescription = ""
            )
        }


    }

}