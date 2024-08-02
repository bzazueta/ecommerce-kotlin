package com.monosoft.ecommercemono.domain.repository

import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.util.Resource
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>

}