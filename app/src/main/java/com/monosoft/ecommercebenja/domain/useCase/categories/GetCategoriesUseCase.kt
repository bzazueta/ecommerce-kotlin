package com.monosoft.ecommercebenja.domain.useCase.categories


import com.monosoft.ecommercebenja.domain.repository.CategoriesRepository
import java.io.File

class GetCategoriesUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke() = repository.getCategories()
}