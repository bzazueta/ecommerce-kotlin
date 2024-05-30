package com.monosoft.ecommercebenja.domain.useCase.products

import com.monosoft.ecommercebenja.domain.useCase.products.FindAllUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.FindByNameUseCase

data class ProductsUseCase(
    val createProduct: CreateProductUseCase,
    val findByCategory: FindByCategoryUseCase,
    val findAll: FindAllUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase,
    val findByName: FindByNameUseCase
)
