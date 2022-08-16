package com.babar.task.data.repository.dataSource

import com.babar.task.data.model.UserAPIResponse
import retrofit2.Response

interface UsersRemoteDataSource {
    suspend fun getUsers(): Response<UserAPIResponse>


}