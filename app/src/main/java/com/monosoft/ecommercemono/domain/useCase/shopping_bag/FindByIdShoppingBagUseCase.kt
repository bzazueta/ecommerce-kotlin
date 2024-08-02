package com.monosoft.ecommercemono.domain.useCase.shopping_bag

import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository


class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) = repository.findById(id)
}