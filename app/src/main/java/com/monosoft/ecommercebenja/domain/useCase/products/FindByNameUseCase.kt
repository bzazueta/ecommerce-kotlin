package com.monosoft.ecommercebenja.domain.useCase.products

import com.monosoft.ecommercebenja.domain.repository.ProductsRepository


class FindByNameUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(name: String) = repository.findByName(name)
}