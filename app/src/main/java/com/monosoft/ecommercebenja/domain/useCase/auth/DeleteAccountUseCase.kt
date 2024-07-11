package com.monosoft.ecommercebenja.domain.useCase.auth

import com.monosoft.ecommercebenja.domain.repository.AuthRepository

class DeleteAccountUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(id: String) = authRepository.delete(id)
}