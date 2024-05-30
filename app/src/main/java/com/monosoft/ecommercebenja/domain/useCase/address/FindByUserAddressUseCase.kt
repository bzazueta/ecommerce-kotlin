package com.monosoft.ecommercebenja.domain.useCase.address

import com.monosoft.ecommercebenja.domain.repository.AddressRepository


class FindByUserAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(idUser: String) = repository.findByUser(idUser)

}