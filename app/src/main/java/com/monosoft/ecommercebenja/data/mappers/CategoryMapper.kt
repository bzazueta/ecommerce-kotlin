package com.monosoft.ecommercebenja.data.mappers

import com.monosoft.ecommercebenja.data.dataSource.local.entity.CategoryEntity
import com.monosoft.ecommercebenja.domain.model.Category


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