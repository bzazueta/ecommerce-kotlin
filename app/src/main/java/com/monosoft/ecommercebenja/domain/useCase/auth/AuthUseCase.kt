package com.monosoft.ecommercebenja.domain.useCase.auth

import com.monosoft.ecommercebenja.domain.useCase.auth.GetSessionDataUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.LogoutSessionUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.SaveSessionUseCase

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutSessionUseCase,
    val updateSession: UpdateSessionUseCase
)
