package com.monosoft.ecommercebenja.domain.useCase.shopping_bag

import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository


class GetTotalUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke()  = repository.getTotal()
}