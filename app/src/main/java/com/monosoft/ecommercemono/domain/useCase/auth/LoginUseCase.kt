package com.monosoft.ecommercemono.domain.useCase.auth

import com.monosoft.ecommercemono.domain.repository.AuthRepository

/**
 * inyectamos la interface authRepository: AuthRepository quien tiene el metodo login
 */

class LoginUseCase (private val authRepository: AuthRepository){

    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)
}