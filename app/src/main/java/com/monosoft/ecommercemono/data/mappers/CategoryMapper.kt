package com.monosoft.ecommercemono.data.mappers

import com.monosoft.ecommercemono.data.dataSource.local.entity.CategoryEntity
import com.monosoft.ecommercemono.domain.model.Category


fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}