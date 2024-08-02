package com.monosoft.ecommercemono.domain.useCase.shopping_bag

import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository


class GetTotalUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke()  = repository.getTotal()
}