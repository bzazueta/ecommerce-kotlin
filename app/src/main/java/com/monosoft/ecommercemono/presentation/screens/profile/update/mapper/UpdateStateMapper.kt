package com.monosoft.ecommercemono.presentation.screens.profile.update.mapper

import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.presentation.screens.profile.update.ProfileUpdateState


fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}