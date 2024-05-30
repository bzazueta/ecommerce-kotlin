package com.monosoft.ecommercebenja.domain.useCase.shopping_bag

import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository


class FindAllShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    operator fun invoke() = repository.findAll()
}