package com.babar.task.presentation.di

import com.babar.task.domain.repository.PostsRepository
import com.babar.task.domain.repository.UsersRepository
import com.babar.task.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
   @Singleton
   @Provides
   fun provideGetUsersUseCase(
       usersRepository: UsersRepository
   ):GetUsersUseCase{
      return GetUsersUseCase(usersRepository)
   }

   @Singleton
   @Provides
   fun provideGetPostsUseCase(
      postsRepository: PostsRepository
   ):GetPostsUseCase{
      return GetPostsUseCase(postsRepository)
   }

}


















