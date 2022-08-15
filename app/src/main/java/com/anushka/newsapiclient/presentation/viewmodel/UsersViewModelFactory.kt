package com.anushka.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.newsapiclient.domain.usecase.*

class UsersViewModelFactory(
    private val app:Application,
    private val getUsersUseCase: GetUsersUseCase,
    private val postsUseCase: GetPostsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(
            app,
            getUsersUseCase,
            postsUseCase
        ) as T
    }
}









