package com.monosoft.ecommercebenja.domain.useCase.categories


import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.domain.repository.CategoriesRepository
import java.io.File

class UpdateCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String, category: Category) = repository.update(id, category)
}