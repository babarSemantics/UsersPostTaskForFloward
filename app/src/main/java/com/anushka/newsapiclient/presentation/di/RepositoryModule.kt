package com.anushka.newsapiclient.presentation.di

import com.anushka.newsapiclient.data.repository.PostsRepositoryImpl
import com.anushka.newsapiclient.data.repository.UsersRepositoryImpl
import com.anushka.newsapiclient.data.repository.dataSource.PostsRemoteDataSource
import com.anushka.newsapiclient.data.repository.dataSource.UsersRemoteDataSource
import com.anushka.newsapiclient.domain.repository.PostsRepository
import com.anushka.newsapiclient.domain.repository.UsersRepository
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














