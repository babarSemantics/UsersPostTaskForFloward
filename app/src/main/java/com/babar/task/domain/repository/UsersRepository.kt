package com.babar.task.domain.repository

import com.babar.task.data.model.UserAPIResponse
import com.babar.task.data.util.Resource

interface UsersRepository{

      suspend fun getUsers(): Resource<UserAPIResponse>
}