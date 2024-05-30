package com.monosoft.ecommercebenja.presentation.screens.admin.category.update.mapper

import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.presentation.screens.admin.category.update.AdminCategoryUpdateState


fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}