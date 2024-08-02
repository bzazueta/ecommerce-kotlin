package com.monosoft.ecommercemono.domain.useCase.products

import com.monosoft.ecommercemono.domain.repository.ProductsRepository


class FindAllUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke() = repository.findAll()
}