package com.monosoft.ecommercemono.domain.useCase.orders

import com.monosoft.ecommercemono.domain.repository.OrdersRepository


class UpdateStatusOrdersUseCase(private val repository: OrdersRepository) {

    suspend operator fun invoke(id: String) = repository.updateStatus(id)

}