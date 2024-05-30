package com.monosoft.ecommercebenja.domain.useCase.users


import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}