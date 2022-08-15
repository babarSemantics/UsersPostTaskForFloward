package com.anushka.newsapiclient.domain.usecase

import com.anushka.newsapiclient.data.model.PostsAPIResponse
import com.anushka.newsapiclient.data.model.UserAPIResponse
import com.anushka.newsapiclient.data.util.Resource
import com.anushka.newsapiclient.domain.repository.PostsRepository
import com.anushka.newsapiclient.domain.repository.UsersRepository

class GetPostsUseCase(private val postsRepository: PostsRepository) {
    suspend fun execute(): Resource<PostsAPIResponse> {
        return postsRepository.getPosts()
    }
}