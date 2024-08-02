package com.monosoft.ecommercemono.domain.useCase.categories


import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.domain.repository.CategoriesRepository

class UpdateCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String, category: Category) = repository.update(id, category)
}