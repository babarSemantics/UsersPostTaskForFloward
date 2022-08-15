package com.anushka.newsapiclient.data.repository

import com.anushka.newsapiclient.data.model.PostsAPIResponse
import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.repository.dataSource.PostsRemoteDataSource
import com.anushka.newsapiclient.data.repository.dataSource.UsersRemoteDataSource
import com.anushka.newsapiclient.data.util.Resource
import com.anushka.newsapiclient.domain.repository.PostsRepository
import com.anushka.newsapiclient.domain.repository.UsersRepository
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