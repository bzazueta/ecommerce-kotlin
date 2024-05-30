package com.monosoft.ecommercebenja.domain.useCase.address

data class AddressUseCase(
    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase,
)
