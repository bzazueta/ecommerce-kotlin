package com.monosoft.ecommercemono.domain.useCase.auth

import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.repository.AuthRepository


class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) =  repository.register(user);

}