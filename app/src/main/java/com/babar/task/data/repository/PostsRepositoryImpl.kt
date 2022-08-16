package com.babar.task.data.repository

import com.babar.task.data.model.PostsAPIResponse
import com.babar.task.data.repository.dataSource.PostsRemoteDataSource
import com.babar.task.data.util.Resource
import com.babar.task.domain.repository.PostsRepository
import retrofit2.Response

class PostsRepositoryImpl(
        private val postsRemoteDataSource: PostsRemoteDataSource,
):PostsRepository {

    override suspend fun getPosts(): Resource<PostsAPIResponse> {
        return responseToResource(postsRemoteDataSource.getPosts())
    }
    private fun responseToResource(response:Response<PostsAPIResponse>):Resource<PostsAPIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}