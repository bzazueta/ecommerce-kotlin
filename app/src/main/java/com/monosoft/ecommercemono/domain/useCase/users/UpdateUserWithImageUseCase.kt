package com.monosoft.ecommercemono.domain.useCase.users


import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}