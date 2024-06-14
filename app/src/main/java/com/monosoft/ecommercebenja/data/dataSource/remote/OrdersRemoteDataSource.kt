package com.optic.ecommerceappmvvm.data.dataSource.remote

import com.monosoft.ecommercebenja.domain.model.Order
import retrofit2.Response

interface OrdersRemoteDataSource {

    suspend fun findAll(): Response<List<Order>>
    suspend fun findByClient(idClient: String): Response<List<Order>>
    suspend fun updateStatus(id: String): Response<Order>

}