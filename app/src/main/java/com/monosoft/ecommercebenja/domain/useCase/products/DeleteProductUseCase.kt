package com.monosoft.ecommercebenja.domain.useCase.products

import com.monosoft.ecommercebenja.domain.repository.ProductsRepository


class DeleteProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}