package com.monosoft.ecommercemono.domain.useCase.categories


import com.monosoft.ecommercemono.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke() = repository.getCategories()
}