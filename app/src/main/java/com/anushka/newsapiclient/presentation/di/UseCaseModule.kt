package com.anushka.newsapiclient.presentation.di

import com.anushka.newsapiclient.domain.repository.PostsRepository
import com.anushka.newsapiclient.domain.repository.UsersRepository
import com.anushka.newsapiclient.domain.usecase.*
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


















