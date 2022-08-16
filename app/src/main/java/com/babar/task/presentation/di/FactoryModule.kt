package com.babar.task.presentation.di

import android.app.Application
import com.babar.task.domain.usecase.*
import com.babar.task.presentation.viewmodel.UsersViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideUsersViewModelFactory(
     application: Application,
     getUsersUseCase: GetUsersUseCase,
     postsUseCase: GetPostsUseCase
  ):UsersViewModelFactory{
      return UsersViewModelFactory(
          application,
          getUsersUseCase,
          postsUseCase
      )
  }

}








