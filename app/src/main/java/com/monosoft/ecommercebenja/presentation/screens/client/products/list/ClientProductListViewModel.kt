package com.monosoft.ecommercebenja.presentation.screens.client.products.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercebenja.domain.model.Product
import com.monosoft.ecommercebenja.domain.useCase.products.ProductsUseCase
import com.monosoft.ecommercebenja.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductListViewModel @Inject constructor(private val productsUseCase: ProductsUseCase): ViewModel() {

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    var search by mutableStateOf("")
    var init by mutableStateOf(false)

    init {
        //getProducts()
    }

    fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findAll().collect() {
            Log.d("ClientProductListViewModel", "Data: $it")
            if(!init) {
                productsResponse = it
            }
        }
    }

    fun getProductsByName(name: String) = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findByName(name).collect() {
            Log.d("ClientProductListViewModel", "Data: $it")
            productsResponse = it
        }
    }

    fun onSearchInput(value: String) {
        init = value.length != 0
        search = value

    }

}