package com.monosoft.ecommercebenja.di

import com.monosoft.ecommercebenja.data.dataSource.local.AuthLocalDataSource
import com.monosoft.ecommercebenja.data.dataSource.local.CategoriesLocalDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.AuthRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.ProductsRemoteDataSource
import com.monosoft.ecommercebenja.data.repository.AddressRepositoryImpl
import com.monosoft.ecommercebenja.data.repository.AuthRepositoryImpl
import com.monosoft.ecommercebenja.data.repository.CategoriesRepositoryImpl
import com.monosoft.ecommercebenja.data.repository.MercadoPagoRepositoryImpl
import com.monosoft.ecommercebenja.data.repository.ProductsRepositoryImpl
import com.monosoft.ecommercebenja.data.repository.ShoppingBagRepositoryImpl
import com.monosoft.ecommercebenja.data.repository.UsersRepositoryImpl
import com.monosoft.ecommercebenja.domain.repository.AddressRepository
import com.monosoft.ecommercebenja.domain.repository.AuthRepository
import com.monosoft.ecommercebenja.domain.repository.CategoriesRepository
import com.monosoft.ecommercebenja.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercebenja.domain.repository.ProductsRepository
import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository
import com.monosoft.ecommercebenja.domain.repository.UsersRepository
import com.monosoft.ecommercebenja.data.dataSource.local.AddressLocalDataSource
import com.monosoft.ecommercebenja.data.dataSource.local.ProductsLocalDataSource
import com.monosoft.ecommercebenja.data.dataSource.local.ShoppingBagLocalDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.AddressRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.CategoriesRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.UsersRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides//se agrega cuando nosotros creamos las clases
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource,authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource, categoriesLocalDataSource)

    @Provides
    fun provideProductsRepository(
        productsRemoteDataSource: ProductsRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource, productsLocalDataSource)//, productsLocalDataSource

    @Provides
    fun provideShoppingBagRepository(
        shoppingBagLocalDataSource: ShoppingBagLocalDataSource
    ): ShoppingBagRepository = ShoppingBagRepositoryImpl(shoppingBagLocalDataSource)

    @Provides
    fun provideAddressRepository(
        addressRemoteDataSource: AddressRemoteDataSource,
        addressLocalDataSource: AddressLocalDataSource
    ): AddressRepository = AddressRepositoryImpl(addressRemoteDataSource,addressLocalDataSource)//,

    @Provides
    fun provideMercadoPagoRepository(
        mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource
    ): MercadoPagoRepository = MercadoPagoRepositoryImpl(mercadoPagoRemoteDataSource)

//    @Provides
//    fun provideOrdersRepository(
//        ordersRemoteDataSource: OrdersRemoteDataSource
//    ): OrdersRepository = OrdersRepositoryImpl(ordersRemoteDataSource)

}