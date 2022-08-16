package com.anushka.newsapiclient.data.api

import com.anushka.newsapiclient.data.model.PostsAPIResponse
import com.anushka.newsapiclient.data.model.UserAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface UsersPostPIService {
  @GET("users")
  suspend fun getUsers(): Response<UserAPIResponse>

  @GET("posts")
  suspend fun getPosts(): Response<PostsAPIResponse>

}