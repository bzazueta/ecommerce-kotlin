package com.monosoft.ecommercebenja.presentation.screens.client.address.create.mapper

import com.monosoft.ecommercebenja.domain.model.Address
import com.monosoft.ecommercebenja.presentation.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address {
    return Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}