package com.anushka.newsapiclient.domain.repository

import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.util.Resource

interface UsersRepository{

      suspend fun getUsers(): Resource<UserAPIResponse>
}