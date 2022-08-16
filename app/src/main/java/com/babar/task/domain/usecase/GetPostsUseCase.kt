package com.babar.task.domain.usecase

import com.babar.task.data.model.PostsAPIResponse
import com.babar.task.data.util.Resource
import com.babar.task.domain.repository.PostsRepository

class GetPostsUseCase(private val postsRepository: PostsRepository) {
    suspend fun execute(): Resource<PostsAPIResponse> {
        return postsRepository.getPosts()
    }
}