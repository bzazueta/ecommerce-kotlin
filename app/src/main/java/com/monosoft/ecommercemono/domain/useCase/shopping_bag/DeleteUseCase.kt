package com.monosoft.ecommercemono.domain.useCase.shopping_bag

import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository


class DeleteUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) {
        repository.delete(id)
    }
}