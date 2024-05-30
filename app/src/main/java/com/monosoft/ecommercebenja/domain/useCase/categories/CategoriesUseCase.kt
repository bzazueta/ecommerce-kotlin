package com.monosoft.ecommercebenja.domain.useCase.categories

import com.monosoft.ecommercebenja.domain.useCase.categories.DeleteCategoryUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.GetCategoriesUseCase

data class CategoriesUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategories: GetCategoriesUseCase,
    val updateCategory: UpdateCategoryUseCase,
    val updateCategoryWithImage: UpdateCategoryWithImageUseCase,
    val deleteCategory: DeleteCategoryUseCase
)
