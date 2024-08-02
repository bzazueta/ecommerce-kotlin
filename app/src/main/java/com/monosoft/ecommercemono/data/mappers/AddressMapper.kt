package com.monosoft.ecommercemono.data.mappers

import com.monosoft.ecommercemono.data.dataSource.local.entity.AddressEntity
import com.monosoft.ecommercemono.domain.model.Address

fun Address.toEntity() : AddressEntity{
    return AddressEntity(
        id = id ?: "",
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}


fun AddressEntity.toAddress(): Address{
    return Address(
        id = id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}