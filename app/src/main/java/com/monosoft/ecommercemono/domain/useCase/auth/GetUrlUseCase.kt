package com.monosoft.ecommercemono.domain.useCase.auth

import com.monosoft.ecommercemono.domain.repository.AuthRepository

class GetUrlUseCase  (private val authRepository: AuthRepository){

    suspend operator fun invoke() = authRepository.getUrlDomain()
}