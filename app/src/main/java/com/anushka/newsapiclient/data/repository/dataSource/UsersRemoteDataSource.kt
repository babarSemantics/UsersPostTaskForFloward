package com.anushka.newsapiclient.data.repository.dataSource

import com.anushka.newsapiclient.data.model.UserAPIResponse
import retrofit2.Response

interface UsersRemoteDataSource {
    suspend fun getUsers(): Response<UserAPIResponse>


}