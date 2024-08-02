package com.monosoft.ecommercemono.domain.useCase.products

import com.monosoft.ecommercemono.domain.repository.ProductsRepository


class DeleteProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}