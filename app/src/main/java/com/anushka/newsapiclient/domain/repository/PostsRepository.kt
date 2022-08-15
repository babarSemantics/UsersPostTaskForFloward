package com.anushka.newsapiclient.domain.repository

import com.anushka.newsapiclient.data.model.PostsAPIResponse
import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.util.Resource


interface PostsRepository{
      suspend fun getPosts(): Resource<PostsAPIResponse>
}