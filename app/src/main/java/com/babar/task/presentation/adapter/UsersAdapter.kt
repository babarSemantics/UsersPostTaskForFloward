package com.babar.task.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.babar.task.MainActivity
import com.babar.task.data.model.User
import com.babar.task.databinding.UserListItemBinding
import com.bumptech.glide.Glide

class UsersAdapter:RecyclerView.Adapter<UsersAdapter.NewsViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
           return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = UserListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NewsViewHolder(
        private val binding:UserListItemBinding,
        private val context:Context,
        ):
        RecyclerView.ViewHolder(binding.root){
           fun bind(user: User){
               Log.i("MYTAG","came here ${user.name}")
               binding.tvUserName.text = user.name
               binding.tvPostCount.text = (context as MainActivity).getRequiredPosts(user.userId).size.toString()

               Glide.with(binding.ivUserThumbNailImage.context).
               load(user.url).
               into(binding.ivUserThumbNailImage)

               binding.root.setOnClickListener {
                  onItemClickListener?.let {
                        it(user)
                  }
               }
           }
        }

        private var onItemClickListener :((User)->Unit)?=null

        fun setOnItemClickListener(listener : (User)->Unit){
            onItemClickListener = listener
        }

}









