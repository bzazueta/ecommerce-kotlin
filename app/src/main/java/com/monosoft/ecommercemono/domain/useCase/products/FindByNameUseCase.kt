package com.monosoft.ecommercemono.domain.useCase.products

import com.monosoft.ecommercemono.domain.repository.ProductsRepository


class FindByNameUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(name: String) = repository.findByName(name)
}