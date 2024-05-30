package com.monosoft.ecommercebenja.domain.useCase.categories


import com.monosoft.ecommercebenja.domain.repository.CategoriesRepository
import java.io.File

class DeleteCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}