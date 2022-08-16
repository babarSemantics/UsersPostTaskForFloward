package com.babar.task.data.api

import com.babar.task.data.model.PostsAPIResponse
import com.babar.task.data.model.UserAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface UsersPostPIService {
  @GET("users")
  suspend fun getUsers(): Response<UserAPIResponse>

  @GET("posts")
  suspend fun getPosts(): Response<PostsAPIResponse>

}