package com.monosoft.ecommercebenja.presentation.screens.client.home.components

import androidx.compose.material3.Icon

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.monosoft.ecommercebenja.presentation.navigation.screens.admin.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController) {

    val screens = listOf(
        //AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.OrderList,
        AdminScreen.Profile,
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    var selectedItem by remember { mutableIntStateOf(0) }

    if (bottomBarDestination) {
        NavigationBar {
//            screens.forEach { screen ->
//               ClientBottomBarItem(
//                   screen = screen,
//                   currentDestination = currentDestination,
//                   navController = navController
//               )
//           }
            screens.forEach { screen_ ->
                NavigationBarItem(
                    icon = { Icon(imageVector = screen_.icon, contentDescription = "") },
                    label = { Text(text = screen_.title) },
                    selected = currentDestination?.hierarchy?.any {
                        it.route == screen_.route
                    } == true,
                    //unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),,
                    onClick = {
                        navController.navigate(route = screen_.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                        }
                    }
                )
            }
        }
//       BottomAppBar {
//           screens.forEach { screen ->
//               ClientBottomBarItem(
//                   screen = screen,
//                   currentDestination = currentDestination,
//                   navController = navController
//               )
//           }
//       }
    }



}