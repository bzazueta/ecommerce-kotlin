package com.monosoft.ecommercemono.domain.useCase.products


import com.monosoft.ecommercemono.domain.model.Product
import com.monosoft.ecommercemono.domain.repository.ProductsRepository
import java.io.File

class CreateProductUseCase(private val repository: ProductsRepository) {

    suspend operator fun invoke(product: Product, files: List<File>) = repository.create(product, files)

}