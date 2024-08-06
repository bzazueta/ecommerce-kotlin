package com.monosoft.ecommercemono.data.repository

import com.monosoft.ecommercemono.data.dataSource.local.AuthLocalDataSource
import com.monosoft.ecommercemono.data.dataSource.remote.AuthRemoteDataSource
import com.monosoft.ecommercemono.domain.model.AuthResponse
import com.monosoft.ecommercemono.domain.model.Url
import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.repository.AuthRepository
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.domain.util.ResponseToRequest
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

    override suspend fun getUrlDomain() : Resource<List<Url>> = ResponseToRequest.send(authRemoteDataSource.getUrlDomain())


    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()
    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(authRemoteDataSource.delete(id)).run {
            return when(this) {
                is Resource.Success -> {
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }


}