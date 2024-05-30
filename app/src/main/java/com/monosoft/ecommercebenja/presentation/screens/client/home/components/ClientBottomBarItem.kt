package com.monosoft.ecommercebenja.presentation.screens.client.home.components
import androidx.compose.material.*
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ClientScreen

@Composable
fun RowScope.ClientBottomBarItem(
    screen: ClientScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    NavigationBar{
        NavigationBarItem(
            label = {
                Text(text = screen.title)
            },
            icon = {
                Icons.Filled.Favorite
            },
            selected = false,
//            selected = currentDestination?.hierarchy?.any {
//                it.route == screen.route
//            } == true,
            //unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),

            onClick = {
//                navController.navigate(route = screen.route) {
//                    popUpTo(navController.graph.findStartDestination().id)
//                }
            }
        )
    }

}

