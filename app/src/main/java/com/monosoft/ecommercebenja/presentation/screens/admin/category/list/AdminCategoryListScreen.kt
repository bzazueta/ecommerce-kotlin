package com.monosoft.ecommercebenja.presentation.screens.admin.category.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components.DeleteCategory
import com.monosoft.ecommercebenja.presentation.screens.admin.category.list.components.GetCategories

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminCategoryListScreen(navController:NavHostController) {//

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 80.dp),
                onClick = {
                    navController.navigate(route = Graph.ADMIN_CATEGORY)
                },
                shape = CircleShape,
                containerColor = Color.Magenta,
                contentColor = Color.Blue
               // backgroundColor = Color.DarkGray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        GetCategories(navController, paddingValues)
    }

    DeleteCategory()

}