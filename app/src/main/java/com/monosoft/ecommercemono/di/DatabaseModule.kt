package com.monosoft.ecommercemono.di

import android.app.Application
import androidx.room.Room
import com.monosoft.ecommercemono.data.dataSource.local.dao.AddressDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.CategoriesDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.ProductsDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.ShoppingBagDao
import com.monosoft.ecommercemono.data.dataSource.local.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides //proveemos la base de datos room
    @Singleton  //app: Application recibe el contexto nos regresa los datos con EcommerceDB
    fun provideDatabase(app: Application): EcommerceDB =
        Room.databaseBuilder(app, EcommerceDB::class.java, "ecommerce_db").fallbackToDestructiveMigration().build()
        //(app, EcommerceDB::class.java, "ecommerce_db") contexto,clase de la base de datos,nombre dela bsade datos

    @Provides //provee la informacion de nuestro dao insert delete update etc
    @Singleton //sirve cuando viene de un patron externo en este caso dao
    fun provideCategoriesDao(db: EcommerceDB): CategoriesDao = db.categoriesDao()

    @Provides
    @Singleton
    fun provideProductsDao(db: EcommerceDB): ProductsDao = db.productsDao()

    @Provides
    @Singleton
    fun provideShoppingBagDao(db: EcommerceDB): ShoppingBagDao = db.shoppingBagDao()

    @Provides
    @Singleton
    fun provideAddressDao(db: EcommerceDB): AddressDao = db.addressDao()

}