package com.babar.task.presentation.di

import com.babar.task.data.api.UsersPostPIService
import com.babar.task.data.repository.dataSource.PostsRemoteDataSource
import com.babar.task.data.repository.dataSource.UsersRemoteDataSource
import com.babar.task.data.repository.dataSourceImpl.PostsRemoteDataSourceImpl
import com.babar.task.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
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












