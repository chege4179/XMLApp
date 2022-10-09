package com.peterchege.retrofitcrashcourse.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.peterchege.retrofitcrashcourse.R
import com.peterchege.retrofitcrashcourse.adapters.PostsAdapter
import com.peterchege.retrofitcrashcourse.api.JsonPlaceholderApi
import com.peterchege.retrofitcrashcourse.databinding.FragmentPostsBinding
import okio.IOException
import retrofit2.HttpException


class AllPostsFragment : Fragment(R.layout.fragment_posts) {
    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding

    private lateinit var postsAdapter: PostsAdapter

    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchPosts()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        val view = binding?.root
        setupRecyclerView()
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    private fun fetchPosts(){
        lifecycleScope.launchWhenCreated {
            binding?.progressBar?.isVisible  = true
            val response = try {
                JsonPlaceholderApi.instance.getAllPosts()
            } catch (e: IOException) {
                Log.e("Error", "IOException, you might not have internet connection")
                binding?.progressBar?.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e("Error", "HttpException, unexpected response")
                binding?.progressBar?.isVisible  = false
                return@launchWhenCreated
            }
            if (response.isNotEmpty()) {
                postsAdapter.posts = response
            } else {
                Log.e("Error", "Response not successful")
            }
            binding?.progressBar?.isVisible  = false
        }
    }
    private fun setupRecyclerView() = binding?.postsRecyclerView?.apply {
        postsAdapter = PostsAdapter()
        adapter = postsAdapter
        layoutManager = LinearLayoutManager(context)
    }
}