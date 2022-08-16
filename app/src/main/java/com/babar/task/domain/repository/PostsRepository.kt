package com.babar.task.domain.repository

import com.babar.task.data.model.PostsAPIResponse
import com.babar.task.data.util.Resource


interface PostsRepository{
      suspend fun getPosts(): Resource<PostsAPIResponse>
}