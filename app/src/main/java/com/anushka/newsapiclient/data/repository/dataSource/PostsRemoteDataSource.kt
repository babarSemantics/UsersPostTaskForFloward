package com.anushka.newsapiclient.data.repository.dataSource

import com.anushka.newsapiclient.data.model.PostsAPIResponse
import com.anushka.newsapiclient.data.model.UserAPIResponse
import retrofit2.Response

interface PostsRemoteDataSource {
    suspend fun getPosts(): Response<PostsAPIResponse>


}