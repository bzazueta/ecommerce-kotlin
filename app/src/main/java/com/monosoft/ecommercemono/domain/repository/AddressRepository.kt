package com.monosoft.ecommercemono.domain.repository

import com.monosoft.ecommercemono.domain.model.Address
import com.monosoft.ecommercemono.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun create(address: Address):Resource<Address>
    fun findByUser(idUser: String): Flow<Resource<List<Address>>>
}