package com.monosoft.ecommercemono.presentation.screens.admin.product.create.mapper

import com.monosoft.ecommercemono.domain.model.Product
import com.monosoft.ecommercemono.presentation.screens.admin.products.create.AdminProductCreateState


fun AdminProductCreateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}