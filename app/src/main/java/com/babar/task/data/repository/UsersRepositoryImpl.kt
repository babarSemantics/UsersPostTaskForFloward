package com.babar.task.data.repository

import com.babar.task.data.model.UserAPIResponse
import com.babar.task.data.repository.dataSource.UsersRemoteDataSource
import com.babar.task.data.util.Resource
import com.babar.task.domain.repository.UsersRepository
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