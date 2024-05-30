package com.monosoft.ecommercebenja.data.mappers

import com.monosoft.ecommercebenja.data.dataSource.local.entity.AddressEntity
import com.monosoft.ecommercebenja.domain.model.Address

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