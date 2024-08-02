package com.monosoft.ecommercemono.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.monosoft.ecommercemono.data.dataSource.local.dao.AddressDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.CategoriesDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.ProductsDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.ShoppingBagDao
import com.monosoft.ecommercemono.data.dataSource.local.entity.AddressEntity
import com.monosoft.ecommercemono.data.dataSource.local.entity.CategoryEntity
import com.monosoft.ecommercemono.data.dataSource.local.entity.ProductEntity
import com.monosoft.ecommercemono.data.dataSource.local.entity.ShoppingBagProductEntity

//

@Database(
    entities = [CategoryEntity::class,ProductEntity::class,ShoppingBagProductEntity::class,AddressEntity::class],
    version = 5,
    exportSchema = false
)
abstract class EcommerceDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao // DATA ACCESS OBJECT
    abstract fun productsDao(): ProductsDao
    abstract fun shoppingBagDao(): ShoppingBagDao
    abstract fun addressDao(): AddressDao
}