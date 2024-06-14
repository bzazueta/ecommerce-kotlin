package com.monosoft.ecommercebenja.domain.useCase.orders

data class OrdersUseCase(
    val findAllOrders: FindAllOrdersUseCase,
    val findByClientOrders: FindByClientOrdersUseCase,
    val updateStatusOrders: UpdateStatusOrdersUseCase
)
