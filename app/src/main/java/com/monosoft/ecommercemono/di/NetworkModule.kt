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
import com.monosoft.ecommercemono.data.dataSource.remote.service.UrlService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
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
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class CustomRetrofit
    @Provides
    @Singleton
    @CustomRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit { // POSTMAN - THUNDER CLIENT - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DefaultRetrofit
    @Provides
    @Singleton
    @DefaultRetrofit
    fun provideRetrofitUrl(okHttpClient: OkHttpClient): Retrofit { // POSTMAN - THUNDER CLIENT - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl("https://9ec4-190-171-70-58.ngrok-free.app")
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
    fun provideUrlService(@NetworkModule.DefaultRetrofit retrofit: Retrofit): UrlService {
        return retrofit.create(UrlService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthService(@NetworkModule.CustomRetrofit retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(@NetworkModule.CustomRetrofit retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesService(@NetworkModule.CustomRetrofit retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsService(@NetworkModule.CustomRetrofit retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    @Singleton
    fun provideAddressService(@NetworkModule.CustomRetrofit retrofit: Retrofit): AddressService {
        return retrofit.create(AddressService::class.java)
    }

    @Provides
    @Singleton
    fun provideMercadoPagoService(@NetworkModule.CustomRetrofit retrofit: Retrofit): MercadoPagoService {
        return retrofit.create(MercadoPagoService::class.java)
    }

    @Provides
    @Singleton
    fun provideOrdersService(@NetworkModule.CustomRetrofit retrofit: Retrofit): OrdersService {
        return retrofit.create(OrdersService::class.java)
    }

}