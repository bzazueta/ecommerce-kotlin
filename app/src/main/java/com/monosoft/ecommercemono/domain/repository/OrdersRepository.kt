package com.monosoft.ecommercemono.domain.repository


import com.monosoft.ecommercemono.domain.model.Order
import com.monosoft.ecommercemono.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {
    fun findAll(): Flow<Resource<List<Order>>>
    fun findByClient(idClient: String): Flow<Resource<List<Order>>>
    suspend fun updateStatus(id: String): Resource<Order>
}