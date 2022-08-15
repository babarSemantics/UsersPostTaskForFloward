package com.anushka.newsapiclient.domain.usecase

import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.util.Resource
import com.anushka.newsapiclient.domain.repository.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository) {
    suspend fun execute(): Resource<UserAPIResponse> {
        return usersRepository.getUsers()
    }
}