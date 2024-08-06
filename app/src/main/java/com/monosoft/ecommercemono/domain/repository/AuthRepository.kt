package com.monosoft.ecommercemono.domain.repository

import com.monosoft.ecommercemono.domain.model.AuthResponse
import com.monosoft.ecommercemono.domain.model.Url
import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.util.Resource
import kotlinx.coroutines.flow.Flow


interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User):  Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
    suspend fun delete(id: String): Resource<Unit>
    suspend fun getUrlDomain(): Resource<List<Url>>
}