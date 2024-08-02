package com.monosoft.ecommercemono.di


import com.monosoft.ecommercemono.data.dataSource.local.datastore.AuthDatastore
import com.monosoft.ecommercemono.data.dataSource.remote.service.AddressService
import com.monosoft.ecommercemono.data.dataSource.remote.service.AuthService
import com.monosoft.ecommercemono.data.dataSource.remote.service.CategoriesService
import com.monosoft.ecommercemono.data.dataSource.remote.service.MercadoPagoService
import com.monosoft.ecommercemono.data.dataSource.remote.service.ProductsService
import com.monosoft.ecommercemono.data.dataSource.remote.service.UsersService
import com.monosoft.ecommercemono.core.Config
import com.monosoft.ecommercemono.data.dataSource.remote.service.OrdersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * modulo de inyeccion de dependencias
 * nos provee retrofit
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //obtenemos el token de AuthDatastore sharedpreference
    @Provides
    @Singleton ////inyectamos el datastore: AuthDatastore
    fun provideOkHttpClient(datastore: AuthDatastore) = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            datastore.getData().first().token
        }
        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    /**
     * proveemos Retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit { // POSTMAN - THUNDER CLIENT - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    /**
     * proveemos authservices
     * le inyectamos retrofit
     */
    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    @Singleton
    fun provideAddressService(retrofit: Retrofit): AddressService {
        return retrofit.create(AddressService::class.java)
    }

    @Provides
    @Singleton
    fun provideMercadoPagoService(retrofit: Retrofit): MercadoPagoService {
        return retrofit.create(MercadoPagoService::class.java)
    }

    @Provides
    @Singleton
    fun provideOrdersService(retrofit: Retrofit): OrdersService {
        return retrofit.create(OrdersService::class.java)
    }

}