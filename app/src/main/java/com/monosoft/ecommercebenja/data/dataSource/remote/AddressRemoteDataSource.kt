package com.monosoft.ecommercebenja.data.dataSource.remote



import com.monosoft.ecommercebenja.domain.model.Address
import retrofit2.Response

interface AddressRemoteDataSource {

    suspend fun create(address: Address): Response<Address>
    suspend fun findByUser(idUser: String): Response<List<Address>>

}