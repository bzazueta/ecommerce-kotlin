package com.monosoft.ecommercemono.domain.useCase.products


import com.monosoft.ecommercemono.domain.model.Product
import com.monosoft.ecommercemono.domain.repository.ProductsRepository
import java.io.File

class UpdateProductWithImageUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product, files: List<File>) = repository.updateWithImage(id, product, files)
}