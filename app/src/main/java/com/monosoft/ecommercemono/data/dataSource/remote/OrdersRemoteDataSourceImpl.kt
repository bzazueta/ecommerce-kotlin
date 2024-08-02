package com.optic.ecommerceappmvvm.data.dataSource.remote


import com.monosoft.ecommercemono.data.dataSource.remote.service.OrdersService
import com.monosoft.ecommercemono.domain.model.Order
import retrofit2.Response

class OrdersRemoteDataSourceImpl(private val ordersService: OrdersService): OrdersRemoteDataSource {
    override suspend fun findAll(): Response<List<Order>> = ordersService.findAll()
    override suspend fun findByClient(idClient: String): Response<List<Order>> = ordersService.findByClient(idClient)
    override suspend fun updateStatus(id: String): Response<Order> = ordersService.updateStatus(id)
}