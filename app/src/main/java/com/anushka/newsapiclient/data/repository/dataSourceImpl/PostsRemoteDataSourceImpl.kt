package com.anushka.newsapiclient.data.repository.dataSourceImpl

import com.anushka.newsapiclient.data.api.UsersPostPIService
import com.anushka.newsapiclient.data.model.PostsAPIResponse
import com.anushka.newsapiclient.data.repository.dataSource.PostsRemoteDataSource
import retrofit2.Response

class PostsRemoteDataSourceImpl(
        private val usersPostPIService: UsersPostPIService
):PostsRemoteDataSource {
    override suspend fun getPosts(): Response<PostsAPIResponse> {
          return usersPostPIService.getPosts()
    }
}