package com.monosoft.ecommercemono.presentation.screens.admin.category.create.mapper

import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.presentation.screens.admin.category.create.AdminCategoryCreateState


fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}