package com.monosoft.ecommercebenja.domain.useCase.users

import com.monosoft.ecommercebenja.domain.useCase.users.UpdateUserUseCase
import com.monosoft.ecommercebenja.domain.useCase.users.UpdateUserWithImageUseCase

data class UsersUseCase(
    val updateUser: UpdateUserUseCase,
    val updateUserWithImage: UpdateUserWithImageUseCase
)
