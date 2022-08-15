package com.anushka.newsapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anushka.newsapiclient.data.model.Post
import com.anushka.newsapiclient.data.util.Resource
import com.anushka.newsapiclient.databinding.ActivityMainBinding
import com.anushka.newsapiclient.presentation.adapter.UsersAdapter
import com.anushka.newsapiclient.presentation.viewmodel.UserViewModel
import com.anushka.newsapiclient.presentation.viewmodel.UsersViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: UsersViewModelFactory
    @Inject
    lateinit var usersAdapter: UsersAdapter
    lateinit var viewModel: UserViewModel
    private var isLoading = false
    private lateinit var binding: ActivityMainBinding
    var postsList = ArrayList<Post>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]
        getPosts()
        observers()
        supportFragmentManager.beginTransaction().add(R.id.container, UsersFragment()).commit()

    }

    ///// hitting api call from view model
    private fun getPosts() {
        viewModel.getPosts()
    }

    private fun observers() {

        ///// get posts observer////

        viewModel.postsLiveData.observe(this) { response ->
            when (response) {
                is Resource.Success -> {

                    hideProgressBar()
                    response.data?.let {
                        postsList = it
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(this, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    fun getRequiredPosts(userId:Int):ArrayList<Post>
    {
        var posts = ArrayList<Post>()
        for (post in postsList){
            if (userId == post.userId){
                posts.add(post)
            }
        }
        return posts
    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        binding.progressBar.visibility = View.INVISIBLE
    }
}