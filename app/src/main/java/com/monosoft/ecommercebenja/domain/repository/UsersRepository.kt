package com.monosoft.ecommercebenja.domain.repository

import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.util.Resource
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>

}