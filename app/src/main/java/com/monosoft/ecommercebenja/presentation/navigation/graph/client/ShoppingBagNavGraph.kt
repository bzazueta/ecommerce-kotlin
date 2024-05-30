package com.monosoft.ecommercebenja.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ShoppingBagScreen
import com.monosoft.ecommercebenja.presentation.screens.client.address.create.ClientAddressCreateScreen
import com.monosoft.ecommercebenja.presentation.screens.client.address.list.ClientAddressListScreen
import com.monosoft.ecommercebenja.presentation.screens.client.payments.form.ClientPaymentsFormScreen
import com.monosoft.ecommercebenja.presentation.screens.client.shopping_bag.ClientShoppingBagScreen


fun NavGraphBuilder.ShoppingBagNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ) {

        composable(
            route = ShoppingBagScreen.ShoppingBag.route,
        ) {
            ClientShoppingBagScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressList.route,
        ) {
            ClientAddressListScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressCreate.route,
        ) {
            ClientAddressCreateScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.PaymentsForm.route,
        ) {
            ClientPaymentsFormScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.PaymentsInstallments.route,
            arguments = listOf(navArgument("payment_form") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("payment_form")?.let {
               // ClientPaymentsInstallmentsScreen(navController, it)
            }
        }
        composable(
            route = ShoppingBagScreen.PaymentsStatus.route,
            arguments = listOf(navArgument("payment_response") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("payment_response")?.let {
                //ClientPaymentsStatusScreen(navController, it)
            }
        }

    }
}