package com.monosoft.ecommercemono.data.dataSource.remote

import com.monosoft.ecommercemono.domain.model.User


import retrofit2.Response
import java.io.File

interface UsersRemoteDataSource {

    suspend fun update(id: String, user: User): Response<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Response<User>

}