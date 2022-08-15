package com.anushka.newsapiclient.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anushka.newsapiclient.data.model.Post
import com.anushka.newsapiclient.databinding.PostsListItemBinding

class PostsAdapter:RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
           return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostsListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = differ.currentList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class PostsViewHolder(
        private val binding:PostsListItemBinding,
        ):RecyclerView.ViewHolder(binding.root){
           fun bind(post: Post){
               binding.tvPostTitle.text = post.title
               binding.tvPostBody.text = post.body
           }
        }
}









