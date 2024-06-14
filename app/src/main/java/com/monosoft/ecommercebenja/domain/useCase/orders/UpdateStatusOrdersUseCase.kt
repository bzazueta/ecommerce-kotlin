package com.monosoft.ecommercebenja.domain.useCase.orders

import com.monosoft.ecommercebenja.domain.repository.OrdersRepository


class UpdateStatusOrdersUseCase(private val repository: OrdersRepository) {

    suspend operator fun invoke(id: String) = repository.updateStatus(id)

}