package com.monosoft.ecommercemono.data.repository

import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.repository.UsersRepository
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.domain.util.ResponseToRequest
import com.monosoft.ecommercemono.data.dataSource.remote.UsersRemoteDataSource
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File) = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )

}