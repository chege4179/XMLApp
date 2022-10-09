package com.peterchege.retrofitcrashcourse.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.peterchege.retrofitcrashcourse.R
import com.peterchege.retrofitcrashcourse.api.JsonPlaceholderApi
import com.peterchege.retrofitcrashcourse.databinding.FragmentSinglePostBinding
import okio.IOException
import retrofit2.HttpException

class SinglePostFragment : Fragment(R.layout.fragment_single_post) {
    private var _binding: FragmentSinglePostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSinglePostBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id")


        if (id != null) {
            getPostById(id = id)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun getPostById(id:String){
        lifecycleScope.launchWhenCreated {
            binding?.progressBar?.isVisible  = true
            val response = try {
                JsonPlaceholderApi.instance.getPostById(id = id)
            } catch (e: IOException) {
                Log.e("Error", "IOException, you might not have internet connection")
                binding?.progressBar?.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e("Error", "HttpException, unexpected response")
                binding?.progressBar?.isVisible  = false
                return@launchWhenCreated
            }
            binding.postTitle.text = response.title
            binding.postBody.text = response.body

            binding?.progressBar?.isVisible  = false
        }
    }
}