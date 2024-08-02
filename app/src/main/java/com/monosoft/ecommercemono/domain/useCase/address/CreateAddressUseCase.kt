package com.monosoft.ecommercemono.domain.useCase.address

import com.monosoft.ecommercemono.domain.model.Address
import com.monosoft.ecommercemono.domain.repository.AddressRepository


class CreateAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(address: Address) = repository.create(address)

}