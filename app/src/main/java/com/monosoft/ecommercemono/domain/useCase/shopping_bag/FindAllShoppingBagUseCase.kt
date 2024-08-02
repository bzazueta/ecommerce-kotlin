package com.monosoft.ecommercemono.domain.useCase.shopping_bag

import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository


class FindAllShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    operator fun invoke() = repository.findAll()
}