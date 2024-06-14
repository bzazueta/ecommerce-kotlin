package com.monosoft.ecommercebenja.domain.repository


import com.monosoft.ecommercebenja.domain.model.Order
import com.monosoft.ecommercebenja.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {
    fun findAll(): Flow<Resource<List<Order>>>
    fun findByClient(idClient: String): Flow<Resource<List<Order>>>
    suspend fun updateStatus(id: String): Resource<Order>
}