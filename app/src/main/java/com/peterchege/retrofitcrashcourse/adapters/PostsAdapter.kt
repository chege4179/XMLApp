package com.peterchege.retrofitcrashcourse.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.peterchege.retrofitcrashcourse.databinding.ItemPostBinding
import com.peterchege.retrofitcrashcourse.models.PostItem

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<PostItem>() {
        override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var posts: List<PostItem>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val post = posts[position]
            postTitle.text = "${post.id}. ${post.title}"
            postBody.text = post.body.substring(0,50)
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Post Id : ${posts[position].id}",Toast.LENGTH_SHORT).show()
        }
    }
}