package com.monosoft.ecommercebenja.domain.useCase.auth

import com.monosoft.ecommercebenja.domain.repository.AuthRepository

/**
 * inyectamos la interface authRepository: AuthRepository quien tiene el metodo login
 */

class LoginUseCase (private val authRepository: AuthRepository){

    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)
}