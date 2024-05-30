package com.monosoft.ecommercebenja.presentation.screens.auth.register.mapper

import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.presentation.screens.auth.register.RegisterState


fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastName,
        email = email,
        phone = phone,
        password = password
    )
}