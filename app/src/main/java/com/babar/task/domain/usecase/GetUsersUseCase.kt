package com.babar.task.domain.usecase

import com.babar.task.data.model.UserAPIResponse
import com.babar.task.data.util.Resource
import com.babar.task.domain.repository.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository) {
    suspend fun execute(): Resource<UserAPIResponse> {
        return usersRepository.getUsers()
    }
}