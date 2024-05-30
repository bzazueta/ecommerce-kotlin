package com.monosoft.ecommercebenja.domain.useCase.products


import com.monosoft.ecommercebenja.domain.model.Product
import com.monosoft.ecommercebenja.domain.repository.ProductsRepository
import java.io.File

class CreateProductUseCase(private val repository: ProductsRepository) {

    suspend operator fun invoke(product: Product, files: List<File>) = repository.create(product, files)

}