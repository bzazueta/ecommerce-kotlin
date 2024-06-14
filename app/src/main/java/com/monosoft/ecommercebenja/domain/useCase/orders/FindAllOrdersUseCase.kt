package com.monosoft.ecommercebenja.domain.useCase.orders

import com.monosoft.ecommercebenja.domain.repository.OrdersRepository


class FindAllOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke() = repository.findAll()

}