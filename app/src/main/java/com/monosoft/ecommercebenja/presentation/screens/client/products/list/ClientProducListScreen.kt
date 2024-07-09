package com.monosoft.ecommercebenja.presentation.screens.client.products.list


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.monosoft.ecommercebenja.presentation.components.DefaultSearchView
import com.monosoft.ecommercebenja.presentation.components.DefaultTopBar
import com.monosoft.ecommercebenja.presentation.screens.client.products.list.components.GetProducts

@Composable
fun ClientProductListScreen(navController: NavHostController,vm: ClientProductListViewModel = hiltViewModel()) {

    vm.getProducts()

    Scaffold(
        topBar = {
            DefaultSearchView(
                value = vm.search,
                onValueChange = { text ->
                    vm.onSearchInput(text)
                },
                navController = navController,
                onClick = {
                    if (vm.search.isNotBlank()) {
                        vm.getProductsByName(vm.search)
                    }
                }
            )
        }
    ) {

        paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }

}