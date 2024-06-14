package com.monosoft.ecommercebenja.di

import com.monosoft.ecommercebenja.data.dataSource.remote.AuthRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.monosoft.ecommercebenja.data.dataSource.remote.ProductsRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.ProductsRemoteDataSourceImpl
import com.monosoft.ecommercebenja.data.dataSource.remote.service.AddressService
import com.monosoft.ecommercebenja.data.dataSource.remote.service.AuthService
import com.monosoft.ecommercebenja.data.dataSource.remote.service.CategoriesService
import com.monosoft.ecommercebenja.data.dataSource.remote.service.MercadoPagoService
import com.monosoft.ecommercebenja.data.dataSource.remote.service.ProductsService
import com.monosoft.ecommercebenja.data.dataSource.remote.service.UsersService
import com.monosoft.ecommercebenja.data.dataSource.remote.AddressRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.AddressRemoteDataSourceImpl
import com.monosoft.ecommercebenja.data.dataSource.remote.CategoriesRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.monosoft.ecommercebenja.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.MercadoPagoRemoteDataSourceImpl
import com.monosoft.ecommercebenja.data.dataSource.remote.UsersRemoteDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.monosoft.ecommercebenja.data.dataSource.remote.service.OrdersService
import com.optic.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSource
import com.optic.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Esta clase nos sirve para proveer o inyectar el authService: AuthService en la clase AuthRemoteDataSourceImpl
 * la cual implementa los metodos de la interface AuthRemoteDataSource login y register
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSourceImpl(usersService)

    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource= CategoriesRemoteDataSourceImpl(categoriesService)

    @Provides
    fun provideProductsRemoteDataSource(productsService: ProductsService): ProductsRemoteDataSource = ProductsRemoteDataSourceImpl(productsService)

     @Provides
     fun provideAddressRemoteDataSource(addressService: AddressService):AddressRemoteDataSource= AddressRemoteDataSourceImpl(addressService)

    @Provides
    fun provideMercadoPagoRemoteDataSource(mercadoPagoService: MercadoPagoService):MercadoPagoRemoteDataSource= MercadoPagoRemoteDataSourceImpl(mercadoPagoService)

    @Provides
    fun provideOrdersRemoteDataSource(ordersService: OrdersService):OrdersRemoteDataSource= OrdersRemoteDataSourceImpl(ordersService)

}