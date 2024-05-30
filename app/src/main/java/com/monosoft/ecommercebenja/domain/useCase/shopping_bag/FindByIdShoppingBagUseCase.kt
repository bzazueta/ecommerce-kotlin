package com.monosoft.ecommercebenja.domain.useCase.shopping_bag

import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository


class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) = repository.findById(id)
}