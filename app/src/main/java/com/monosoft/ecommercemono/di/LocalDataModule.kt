package com.monosoft.ecommercemono.di


import com.monosoft.ecommercemono.data.dataSource.local.AuthLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.AuthLocalDataSourceImpl
import com.monosoft.ecommercemono.data.dataSource.local.CategoriesLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.monosoft.ecommercemono.data.dataSource.local.dao.AddressDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.CategoriesDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.ProductsDao
import com.monosoft.ecommercemono.data.dataSource.local.dao.ShoppingBagDao
import com.monosoft.ecommercemono.data.dataSource.local.datastore.AuthDatastore
import com.monosoft.ecommercemono.data.dataSource.local.AddressLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.AddressLocalDataSourceImpl
import com.monosoft.ecommercemono.data.dataSource.local.ProductsLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.ProductsLocalDataSourceImpl
import com.monosoft.ecommercemono.data.dataSource.local.ShoppingBagLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.ShoppingBagLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    /**
     * proveemos authDatastore: AuthDatastore
     */
    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource = CategoriesLocalDataSourceImpl(categoriesDao)

    @Provides
    fun provideProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource = ProductsLocalDataSourceImpl(productsDao)

    @Provides
    fun provideShoppingBagLocalDataSource(shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource = ShoppingBagLocalDataSourceImpl(shoppingBagDao)

    @Provides
    fun provideAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource = AddressLocalDataSourceImpl(addressDao)

}