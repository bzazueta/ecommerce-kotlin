package com.monosoft.ecommercebenja.domain.useCase.products

import com.monosoft.ecommercebenja.domain.repository.ProductsRepository


class FindByCategoryUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(idCategory: String) = repository.findByCategory(idCategory)
}