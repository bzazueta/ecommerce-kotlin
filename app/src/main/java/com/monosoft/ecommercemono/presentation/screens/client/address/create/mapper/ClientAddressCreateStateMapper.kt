package com.monosoft.ecommercemono.presentation.screens.client.address.create.mapper

import com.monosoft.ecommercemono.domain.model.Address
import com.monosoft.ecommercemono.presentation.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address {
    return Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}