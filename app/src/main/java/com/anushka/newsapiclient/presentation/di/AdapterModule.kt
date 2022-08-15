package com.anushka.newsapiclient.presentation.di

import com.anushka.newsapiclient.presentation.adapter.PostsAdapter
import com.anushka.newsapiclient.presentation.adapter.UsersAdapter
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