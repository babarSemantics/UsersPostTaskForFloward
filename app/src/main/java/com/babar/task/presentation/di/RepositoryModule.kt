package com.babar.task.presentation.di

import com.babar.task.data.repository.PostsRepositoryImpl
import com.babar.task.data.repository.UsersRepositoryImpl
import com.babar.task.data.repository.dataSource.PostsRemoteDataSource
import com.babar.task.data.repository.dataSource.UsersRemoteDataSource
import com.babar.task.domain.repository.PostsRepository
import com.babar.task.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource
    ): UsersRepository {
        return UsersRepositoryImpl(
            usersRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun providePostsRepository(
        postsRemoteDataSource: PostsRemoteDataSource
    ): PostsRepository {
        return PostsRepositoryImpl(
            postsRemoteDataSource
        )
    }

}














