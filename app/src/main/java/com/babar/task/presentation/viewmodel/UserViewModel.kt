package com.babar.task.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.babar.task.data.model.PostsAPIResponse
import com.babar.task.data.model.UserAPIResponse
import com.babar.task.data.util.Resource
import com.babar.task.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class UserViewModel(
    private val app:Application,
    private val getUsersUseCase: GetUsersUseCase,
    private val postsUseCase: GetPostsUseCase
) : AndroidViewModel(app) {
    val usersLiveData: MutableLiveData<Resource<UserAPIResponse>> = MutableLiveData()
    val postsLiveData: MutableLiveData<Resource<PostsAPIResponse>> = MutableLiveData()

    fun getUsers() = viewModelScope.launch(Dispatchers.IO) {
        usersLiveData.postValue(Resource.Loading())
        try{
      if(isNetworkAvailable(app)) {

          val apiResult = getUsersUseCase.execute()
          usersLiveData.postValue(apiResult)
      }else{
          usersLiveData.postValue(Resource.Error("Internet is not available"))
      }

        }catch (e:Exception){
            usersLiveData.postValue(Resource.Error(e.message.toString()))
        }

    }

    fun getPosts() = viewModelScope.launch(Dispatchers.IO) {
        postsLiveData.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)) {

                val apiResult = postsUseCase.execute()
                postsLiveData.postValue(apiResult)
            }else{
                postsLiveData.postValue(Resource.Error("Internet is not available"))
            }

        }catch (e:Exception){
            postsLiveData.postValue(Resource.Error(e.message.toString()))
        }

    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

}














