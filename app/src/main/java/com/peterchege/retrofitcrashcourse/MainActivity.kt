package com.peterchege.retrofitcrashcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.peterchege.retrofitcrashcourse.databinding.ActivityMainBinding
import com.peterchege.retrofitcrashcourse.ui.fragments.AllPostsFragment
import com.peterchege.retrofitcrashcourse.ui.fragments.SinglePostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}