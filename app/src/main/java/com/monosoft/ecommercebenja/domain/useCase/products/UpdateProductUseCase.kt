package com.monosoft.ecommercebenja.domain.useCase.products

import com.monosoft.ecommercebenja.domain.model.Product
import com.monosoft.ecommercebenja.domain.repository.ProductsRepository


class UpdateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product) = repository.update(id, product)
}