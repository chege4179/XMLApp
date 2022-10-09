package com.peterchege.retrofitcrashcourse.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.peterchege.retrofitcrashcourse.R
import com.peterchege.retrofitcrashcourse.databinding.FragmentSinglePostBinding

class SinglePostFragment : Fragment(R.layout.fragment_single_post) {
    private var _binding: FragmentSinglePostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSinglePostBinding.inflate(inflater, container, false)

//        binding.fragmentTextView1.text = "Example Fragment"
//        binding.fragmentTextView2.text = "works in fragments"
//        binding.includeLayout.includeTextView1.text = "and with"
//        binding.includeLayout.includeTextView2.text = "include layouts"

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}