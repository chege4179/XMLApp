package com.peterchege.retrofitcrashcourse.api.repositories

import com.peterchege.retrofitcrashcourse.api.JsonPlaceholderApi
import com.peterchege.retrofitcrashcourse.api.responses.PostsResponse
import com.peterchege.retrofitcrashcourse.models.PostItem

class PostRepository(
    private val api:JsonPlaceholderApi
) {
    suspend fun getPosts():PostsResponse{
        return api.getAllPosts()

    }
    suspend fun getPostById(id:String):PostItem{
        return api.getPostById(id = id)
    }
}