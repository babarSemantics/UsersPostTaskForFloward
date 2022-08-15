package com.anushka.newsapiclient.presentation.di

import com.anushka.newsapiclient.data.api.UsersPostPIService
import com.anushka.newsapiclient.data.repository.dataSource.PostsRemoteDataSource
import com.anushka.newsapiclient.data.repository.dataSource.UsersRemoteDataSource
import com.anushka.newsapiclient.data.repository.dataSourceImpl.PostsRemoteDataSourceImpl
import com.anushka.newsapiclient.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(
        usersPostPIService: UsersPostPIService
    ): UsersRemoteDataSource {
       return UsersRemoteDataSourceImpl(usersPostPIService)
    }

    @Singleton
    @Provides
    fun providePostsRemoteDataSource(
        usersPostPIService: UsersPostPIService
    ): PostsRemoteDataSource {
        return PostsRemoteDataSourceImpl(usersPostPIService)
    }

}












