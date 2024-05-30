package com.monosoft.ecommercebenja.domain.useCase.auth

import com.monosoft.ecommercebenja.domain.model.AuthResponse
import com.monosoft.ecommercebenja.domain.repository.AuthRepository


class LogoutSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}