package com.monosoft.ecommercebenja.presentation.screens.admin.product.create.mapper

import com.monosoft.ecommercebenja.domain.model.Product
import com.monosoft.ecommercebenja.presentation.screens.admin.products.create.AdminProductCreateState


fun AdminProductCreateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}