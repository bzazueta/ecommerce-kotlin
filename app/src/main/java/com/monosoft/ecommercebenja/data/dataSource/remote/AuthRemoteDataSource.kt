package com.monosoft.ecommercebenja.data.dataSource.remote


import com.monosoft.ecommercebenja.domain.model.AuthResponse
import com.monosoft.ecommercebenja.domain.model.User
import retrofit2.Response

/**
 * esta clase nos trae la informacion de una api de un servidor
 */
interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>

}