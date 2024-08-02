package com.monosoft.ecommercemono.presentation.screens.client.home.components
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.monosoft.ecommercemono.presentation.navigation.screens.client.ClientScreen

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

