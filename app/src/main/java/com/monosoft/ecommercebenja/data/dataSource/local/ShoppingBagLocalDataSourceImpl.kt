package com.monosoft.ecommercebenja.data.dataSource.local


import com.monosoft.ecommercebenja.data.dataSource.local.dao.ShoppingBagDao
import com.monosoft.ecommercebenja.data.dataSource.local.entity.ShoppingBagProductEntity
import kotlinx.coroutines.flow.Flow

class ShoppingBagLocalDataSourceImpl(private val shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource {

    override suspend fun insert(product: ShoppingBagProductEntity) = shoppingBagDao.insert(product)

    override suspend fun insertAll(products: List<ShoppingBagProductEntity>) = shoppingBagDao.insertAll(products)

    override suspend fun getTotal(): Double = shoppingBagDao.getTotal()

    override fun findAll(): Flow<List<ShoppingBagProductEntity>> = shoppingBagDao.findAll()

    override suspend fun findById(id: String): ShoppingBagProductEntity = shoppingBagDao.findById(id)

    override suspend fun update(id: String, quantity: Int) = shoppingBagDao.update(id, quantity)

    override suspend fun delete(id: String) = shoppingBagDao.delete(id)
}