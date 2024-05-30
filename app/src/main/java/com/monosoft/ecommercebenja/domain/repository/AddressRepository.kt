package com.monosoft.ecommercebenja.domain.repository

import com.monosoft.ecommercebenja.domain.model.Address
import com.monosoft.ecommercebenja.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun create(address: Address):Resource<Address>
    fun findByUser(idUser: String): Flow<Resource<List<Address>>>
}