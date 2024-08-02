package com.monosoft.ecommercemono.domain.useCase.auth

import com.monosoft.ecommercemono.domain.repository.AuthRepository

class DeleteAccountUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(id: String) = authRepository.delete(id)
}