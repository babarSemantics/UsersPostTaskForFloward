package com.babar.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.babar.task.data.model.Post
import com.babar.task.databinding.FragmentPostsBinding
import com.babar.task.presentation.adapter.PostsAdapter
import com.babar.task.presentation.viewmodel.UserViewModel
import com.bumptech.glide.Glide


class PostsFragment : Fragment() {
    private lateinit var fragmentPostsBinding: FragmentPostsBinding
    private lateinit var viewModel : UserViewModel
    private var postsList = ArrayList<Post>()
    private var url = ""
    private var userId = 0
    private lateinit var postAdapter: PostsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentPostsBinding = FragmentPostsBinding.bind(view)
        postAdapter = PostsAdapter()
        val bundle = this.arguments
        if (bundle != null) {
            url = bundle.getString("user", "")
            userId = bundle.getInt("userId", 0)
        }
        Glide.with(fragmentPostsBinding.ivUserImage.context).
        load(url).
        into(fragmentPostsBinding.ivUserImage)

        postsList = (activity as MainActivity).getRequiredPosts(userId)
        viewModel=(activity as MainActivity).viewModel

        setUpAdapter()
    }

    private fun setUpAdapter() {
        fragmentPostsBinding.rvPosts.apply {
            layoutManager = LinearLayoutManager(activity)
            fragmentPostsBinding.rvPosts.adapter = postAdapter
        }

        postAdapter.differ.submitList(postsList.toList())
    }
}







