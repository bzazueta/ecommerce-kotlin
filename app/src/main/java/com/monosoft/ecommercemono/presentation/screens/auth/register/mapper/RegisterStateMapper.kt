package com.monosoft.ecommercemono.presentation.screens.auth.register.mapper

import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.presentation.screens.auth.register.RegisterState


fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastName,
        email = email,
        phone = phone,
        password = password
    )
}