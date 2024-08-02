package com.monosoft.ecommercemono.domain.useCase.products

import com.monosoft.ecommercemono.domain.model.Product
import com.monosoft.ecommercemono.domain.repository.ProductsRepository


class UpdateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product) = repository.update(id, product)
}