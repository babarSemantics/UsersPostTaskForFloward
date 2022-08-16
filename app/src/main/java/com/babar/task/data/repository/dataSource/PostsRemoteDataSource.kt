package com.babar.task.data.repository.dataSource

import com.babar.task.data.model.PostsAPIResponse
import retrofit2.Response

interface PostsRemoteDataSource {
    suspend fun getPosts(): Response<PostsAPIResponse>


}