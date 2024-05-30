package com.monosoft.ecommercebenja.domain.useCase.address

import com.monosoft.ecommercebenja.domain.model.Address
import com.monosoft.ecommercebenja.domain.repository.AddressRepository


class CreateAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(address: Address) = repository.create(address)

}