package com.monosoft.ecommercebenja.domain.useCase.shopping_bag

import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository


class DeleteUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) {
        repository.delete(id)
    }
}