package com.monosoft.ecommercemono.presentation.screens.admin.product.update.mapper


import com.monosoft.ecommercemono.domain.model.Product
import com.monosoft.ecommercemono.presentation.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price,
        imagesToUpdate = imagesToUpdate.toList(),
        image1 = image1,
        image2 = image2
    )
}