package com.monosoft.ecommercebenja.data.dataSource.local

import com.monosoft.ecommercebenja.data.dataSource.local.datastore.AuthDatastore
import com.monosoft.ecommercebenja.domain.model.AuthResponse
import com.monosoft.ecommercebenja.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore):
    AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}