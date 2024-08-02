package com.monosoft.ecommercemono.domain.useCase.auth

import com.monosoft.ecommercemono.domain.repository.AuthRepository


class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}