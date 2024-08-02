package com.monosoft.ecommercemono.domain.useCase.address

import com.monosoft.ecommercemono.domain.repository.AddressRepository


class FindByUserAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(idUser: String) = repository.findByUser(idUser)

}