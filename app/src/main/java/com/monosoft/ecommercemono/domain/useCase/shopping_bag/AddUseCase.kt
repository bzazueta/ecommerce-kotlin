package com.monosoft.ecommercemono.domain.useCase.shopping_bag

import com.monosoft.ecommercemono.domain.model.ShoppingBagProduct
import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository


class AddUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repository.add(shoppingBagProduct)
    }
}