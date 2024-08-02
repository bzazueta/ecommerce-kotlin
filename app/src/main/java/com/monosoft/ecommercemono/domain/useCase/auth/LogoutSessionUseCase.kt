package com.monosoft.ecommercemono.domain.useCase.auth

import com.monosoft.ecommercemono.domain.repository.AuthRepository


class LogoutSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}