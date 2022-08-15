package com.anushka.newsapiclient.data.repository.dataSourceImpl

import com.anushka.newsapiclient.data.api.UsersPostPIService
import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.repository.dataSource.UsersRemoteDataSource
import retrofit2.Response

class UsersRemoteDataSourceImpl(
        private val usersPostPIService: UsersPostPIService
):UsersRemoteDataSource {
    override suspend fun getUsers(): Response<UserAPIResponse> {
          return usersPostPIService.getUsers()
    }
}