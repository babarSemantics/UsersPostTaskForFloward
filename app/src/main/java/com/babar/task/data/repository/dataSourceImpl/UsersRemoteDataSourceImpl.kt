package com.babar.task.data.repository.dataSourceImpl

import com.babar.task.data.api.UsersPostPIService
import com.babar.task.data.model.UserAPIResponse
import com.babar.task.data.repository.dataSource.UsersRemoteDataSource
import retrofit2.Response

class UsersRemoteDataSourceImpl(
        private val usersPostPIService: UsersPostPIService
):UsersRemoteDataSource {
    override suspend fun getUsers(): Response<UserAPIResponse> {
          return usersPostPIService.getUsers()
    }
}