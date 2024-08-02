package com.monosoft.ecommercemono.presentation.screens.admin.category.update.mapper

import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.presentation.screens.admin.category.update.AdminCategoryUpdateState


fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}