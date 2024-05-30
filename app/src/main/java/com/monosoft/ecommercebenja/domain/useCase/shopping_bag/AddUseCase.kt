package com.monosoft.ecommercebenja.domain.useCase.shopping_bag

import com.monosoft.ecommercebenja.domain.model.ShoppingBagProduct
import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository


class AddUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repository.add(shoppingBagProduct)
    }
}