package com.babar.task.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.babar.task.domain.usecase.*

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









