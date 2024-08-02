package com.monosoft.ecommercemono.domain.useCase.users

import com.monosoft.ecommercemono.domain.model.User
import com.monosoft.ecommercemono.domain.repository.UsersRepository


class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}