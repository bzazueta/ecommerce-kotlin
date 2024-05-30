package com.monosoft.ecommercebenja.presentation.screens.profile.update.mapper

import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.presentation.screens.profile.update.ProfileUpdateState


fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}