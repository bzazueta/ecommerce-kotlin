package com.monosoft.ecommercemono.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutSessionUseCase,
    val updateSession: UpdateSessionUseCase,
    val deleteAccountUseCase: DeleteAccountUseCase
)
