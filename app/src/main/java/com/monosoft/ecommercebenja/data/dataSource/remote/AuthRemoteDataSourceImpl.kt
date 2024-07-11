package com.monosoft.ecommercebenja.data.dataSource.remote

import com.monosoft.ecommercebenja.data.dataSource.remote.service.AuthService
import com.monosoft.ecommercebenja.domain.model.AuthResponse
import com.monosoft.ecommercebenja.domain.model.User
import retrofit2.Response

/**
 * pasamos por constructor nuestro service private val authService: AuthService
 * este  authService: AuthService nos lo provee la carpeta di que es donde declaramos
 * nuestras inyeccions de dependencias
 */
class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
    override suspend fun delete(idUser: String): Response<Unit> {

        return  authService.delete(idUser)
    }

}