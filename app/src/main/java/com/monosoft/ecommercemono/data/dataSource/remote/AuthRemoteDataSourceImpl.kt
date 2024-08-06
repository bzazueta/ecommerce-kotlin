package com.monosoft.ecommercemono.data.dataSource.remote

import com.monosoft.ecommercemono.data.dataSource.remote.service.AuthService
import com.monosoft.ecommercemono.data.dataSource.remote.service.UrlService
import com.monosoft.ecommercemono.domain.model.AuthResponse
import com.monosoft.ecommercemono.domain.model.Url
import com.monosoft.ecommercemono.domain.model.User
import retrofit2.Response

/**
 * pasamos por constructor nuestro service private val authService: AuthService
 * este  authService: AuthService nos lo provee la carpeta di que es donde declaramos
 * nuestras inyeccions de dependencias
 */
class AuthRemoteDataSourceImpl(private val authService: AuthService,private  val urlService: UrlService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
    override suspend fun delete(idUser: String): Response<Unit> {

        return  authService.delete(idUser)
    }

    override suspend fun getUrlDomain(): Response<List<Url>> {
       return urlService.getUrlDomain()
    }

}