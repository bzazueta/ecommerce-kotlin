package com.monosoft.ecommercebenja.domain.useCase.auth

import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.repository.AuthRepository


class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) =  repository.register(user);

}