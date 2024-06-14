package com.monosoft.ecommercebenja.data.repository

import com.monosoft.ecommercebenja.domain.model.Order
import com.monosoft.ecommercebenja.domain.repository.OrdersRepository
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.domain.util.ResponseToRequest
import com.optic.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrdersRepositoryImpl(private val remoteDataSource: OrdersRemoteDataSource): OrdersRepository {

    override fun findAll(): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findAll()))
    }

    override fun findByClient(idClient: String): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByClient(idClient)))
    }

    override suspend fun updateStatus(id: String): Resource<Order> = ResponseToRequest.send(
        remoteDataSource.updateStatus(id)
    )
}