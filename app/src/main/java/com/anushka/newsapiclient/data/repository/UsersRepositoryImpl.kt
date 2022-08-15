package com.anushka.newsapiclient.data.repository

import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.repository.dataSource.UsersRemoteDataSource
import com.anushka.newsapiclient.data.util.Resource
import com.anushka.newsapiclient.domain.repository.UsersRepository
import retrofit2.Response

class UsersRepositoryImpl(
        private val usersRemoteDataSource: UsersRemoteDataSource,
):UsersRepository {

    override suspend fun getUsers(): Resource<UserAPIResponse> {
        return responseToResource(usersRemoteDataSource.getUsers())
    }
    private fun responseToResource(response:Response<UserAPIResponse>):Resource<UserAPIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}