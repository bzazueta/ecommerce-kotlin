package com.monosoft.ecommercemono.presentation.screens.admin.order.detail

import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercemono.domain.model.Order
import com.monosoft.ecommercemono.domain.useCase.orders.OrdersUseCase
import com.monosoft.ecommercemono.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminOrderDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val ordersUseCase: OrdersUseCase
): ViewModel() {

    var data = savedStateHandle.get<String>("order")
    var order = Order.fromJson(data!!)
    var ordersStatusResponse by mutableStateOf<Resource<Order>?>(null)
        private set
    var totalToPay by mutableStateOf(0.0)
        private set

    init {
        getTotal()
    }

    fun getTotal() {
        order.orderHasProducts?.forEach { ohp ->
            totalToPay = totalToPay + (ohp.quantity * ohp.product.price)
        }
    }

    fun updateStatus(id: String) = viewModelScope.launch {
        ordersStatusResponse = Resource.Loading
        val result = ordersUseCase.updateStatusOrders(id)
        ordersStatusResponse = result
    }

}