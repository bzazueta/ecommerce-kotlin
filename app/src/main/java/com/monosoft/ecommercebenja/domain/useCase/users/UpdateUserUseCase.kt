package com.monosoft.ecommercebenja.domain.useCase.users

import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.repository.UsersRepository


class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}