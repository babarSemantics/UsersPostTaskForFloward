package com.babar.task.presentation.di

import com.babar.task.presentation.adapter.PostsAdapter
import com.babar.task.presentation.adapter.UsersAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
   @Singleton
   @Provides
   fun provideUsersAdapter():UsersAdapter{
       return UsersAdapter()
   }

    @Singleton
    @Provides
    fun providePostsAdapter():PostsAdapter{
        return PostsAdapter()
    }
}