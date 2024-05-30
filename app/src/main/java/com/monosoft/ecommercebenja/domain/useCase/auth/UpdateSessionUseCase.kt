package com.monosoft.ecommercebenja.domain.useCase.auth

import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.repository.AuthRepository


class UpdateSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.updateSession(user)
}