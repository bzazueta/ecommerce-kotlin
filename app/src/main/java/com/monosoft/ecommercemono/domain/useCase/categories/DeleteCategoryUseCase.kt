package com.monosoft.ecommercemono.domain.useCase.categories


import com.monosoft.ecommercemono.domain.repository.CategoriesRepository

class DeleteCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}