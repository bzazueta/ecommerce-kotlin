package com.monosoft.ecommercemono.domain.useCase.products

import com.monosoft.ecommercemono.domain.repository.ProductsRepository


class FindByCategoryUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(idCategory: String) = repository.findByCategory(idCategory)
}