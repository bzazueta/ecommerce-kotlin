package com.monosoft.ecommercemono.domain.useCase.address

data class AddressUseCase(
    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase,
)
