package com.monosoft.ecommercemono.data.dataSource.remote


import com.monosoft.ecommercemono.domain.model.AuthResponse
import com.monosoft.ecommercemono.domain.model.Url
import com.monosoft.ecommercemono.domain.model.User
import retrofit2.Response

/**
 * esta clase nos trae la informacion de una api de un servidor
 */
interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>
    suspend fun delete(idUser: String): Response<Unit>
    suspend fun getUrlDomain(): Response<List<Url>>

}