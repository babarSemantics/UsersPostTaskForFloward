package com.babar.task.data.repository.dataSourceImpl

import com.babar.task.data.api.UsersPostPIService
import com.babar.task.data.model.PostsAPIResponse
import com.babar.task.data.repository.dataSource.PostsRemoteDataSource
import retrofit2.Response

class PostsRemoteDataSourceImpl(
        private val usersPostPIService: UsersPostPIService
):PostsRemoteDataSource {
    override suspend fun getPosts(): Response<PostsAPIResponse> {
          return usersPostPIService.getPosts()
    }
}