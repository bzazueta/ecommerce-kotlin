package com.monosoft.ecommercemono.data.mappers

import com.monosoft.ecommercemono.data.dataSource.local.entity.ShoppingBagProductEntity
import com.monosoft.ecommercemono.domain.model.ShoppingBagProduct


fun ShoppingBagProduct.toEntity(): ShoppingBagProductEntity {
    return ShoppingBagProductEntity(
        id = id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}

fun ShoppingBagProductEntity.toShoppingBagProduct(): ShoppingBagProduct {
    return ShoppingBagProduct(
        id = id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}