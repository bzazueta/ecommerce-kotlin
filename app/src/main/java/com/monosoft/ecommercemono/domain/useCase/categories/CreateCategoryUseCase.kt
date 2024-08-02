package com.monosoft.ecommercemono.domain.useCase.categories


import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}