package com.monosoft.ecommercebenja.domain.useCase.orders

import com.monosoft.ecommercebenja.domain.repository.OrdersRepository


class FindByClientOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke(idClient: String) = repository.findByClient(idClient)

}