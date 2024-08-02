package com.monosoft.ecommercemono.domain.useCase.orders

import com.monosoft.ecommercemono.domain.repository.OrdersRepository


class FindByClientOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke(idClient: String) = repository.findByClient(idClient)

}