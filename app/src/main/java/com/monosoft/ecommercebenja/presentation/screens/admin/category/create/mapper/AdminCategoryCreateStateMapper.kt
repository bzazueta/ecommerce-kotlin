package com.monosoft.ecommercebenja.presentation.screens.admin.category.create.mapper

import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.presentation.screens.admin.category.create.AdminCategoryCreateState


fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}