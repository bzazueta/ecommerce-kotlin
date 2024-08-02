package com.monosoft.ecommercemono.presentation.screens.admin.order.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercemono.domain.model.Order
import com.monosoft.ecommercemono.domain.useCase.orders.OrdersUseCase
import com.monosoft.ecommercemono.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminOrderListViewModel @Inject constructor(private val ordersUseCase: OrdersUseCase): ViewModel() {

    var ordersResponse by mutableStateOf<Resource<List<Order>>?>(null)
//    var ordersByClientResponse by mutableStateOf<Resource<List<Order>>?>(null)
//    var ordersStatusResponse by mutableStateOf<Resource<Order>?>(null)

    init {
        getOrders()
    }
    fun getOrders() = viewModelScope.launch {
        ordersResponse = Resource.Loading
        ordersUseCase.findAllOrders().collect() {
            ordersResponse = it
            Log.d("AdminOrderListViewModel", "Data Orders: ${ordersResponse}")
        }
    }

//    fun getOrdersByClient(idClient: String) = viewModelScope.launch {
//        ordersByClientResponse = Resource.Loading
//        ordersUseCase.findByClientOrders(idClient).collect() {
//            ordersByClientResponse = it
//            Log.d("AdminOrderListViewModel", "Data Orders By Client: ${ordersByClientResponse}")
//        }
//    }
//


}