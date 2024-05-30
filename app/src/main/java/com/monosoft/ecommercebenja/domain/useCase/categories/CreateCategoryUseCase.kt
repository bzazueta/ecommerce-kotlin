package com.monosoft.ecommercebenja.domain.useCase.categories


import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}