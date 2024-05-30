package com.monosoft.ecommercebenja.data.repository

import com.monosoft.ecommercebenja.data.dataSource.local.AuthLocalDataSource
import com.monosoft.ecommercebenja.data.dataSource.remote.AuthRemoteDataSource
import com.monosoft.ecommercebenja.domain.model.AuthResponse
import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.repository.AuthRepository
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

/**
 * pasamos por constructor nuestro service private val authRemoteDataSource: AuthRemoteDataSource
 * este  authRemoteDataSource: AuthRemoteDataSource nos lo provee la carpeta di que es donde declaramos
 * nuestras inyecciones de dependencias. ademas nos provee los datos del servidor
 */
class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}