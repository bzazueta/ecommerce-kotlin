package com.monosoft.ecommercebenja.domain.useCase.products

import com.monosoft.ecommercebenja.domain.repository.ProductsRepository


class FindAllUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke() = repository.findAll()
}