package com.monosoft.ecommercemono.di

import com.monosoft.ecommercemono.data.dataSource.local.AuthLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.CategoriesLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.AuthRemoteDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.ProductsRemoteDataSource
import com.monosoft.ecommercemono.data.repository.AddressRepositoryImpl
import com.monosoft.ecommercemono.data.repository.AuthRepositoryImpl
import com.monosoft.ecommercemono.data.repository.CategoriesRepositoryImpl
import com.monosoft.ecommercemono.data.repository.MercadoPagoRepositoryImpl
import com.monosoft.ecommercemono.data.repository.ProductsRepositoryImpl
import com.monosoft.ecommercemono.data.repository.ShoppingBagRepositoryImpl
import com.monosoft.ecommercemono.data.repository.UsersRepositoryImpl
import com.monosoft.ecommercemono.domain.repository.AddressRepository
import com.monosoft.ecommercemono.domain.repository.AuthRepository
import com.monosoft.ecommercemono.domain.repository.CategoriesRepository
import com.monosoft.ecommercemono.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercemono.domain.repository.ProductsRepository
import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository
import com.monosoft.ecommercemono.domain.repository.UsersRepository
import com.monosoft.ecommercemono.data.dataSource.local.AddressLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.ProductsLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.local.ShoppingBagLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.AddressRemoteDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.CategoriesRemoteDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.UsersRemoteDataSource
import com.monosoft.ecommercemono.data.repository.OrdersRepositoryImpl
import com.monosoft.ecommercemono.domain.repository.OrdersRepository
import com.optic.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSource
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

    @Provides
    fun provideOrdersRepository(
        ordersRemoteDataSource: OrdersRemoteDataSource
    ): OrdersRepository = OrdersRepositoryImpl(ordersRemoteDataSource)

}