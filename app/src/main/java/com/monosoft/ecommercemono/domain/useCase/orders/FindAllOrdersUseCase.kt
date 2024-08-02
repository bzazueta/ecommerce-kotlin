package com.monosoft.ecommercemono.domain.useCase.orders

import com.monosoft.ecommercemono.domain.repository.OrdersRepository


class FindAllOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke() = repository.findAll()

}