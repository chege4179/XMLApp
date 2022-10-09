package com.peterchege.retrofitcrashcourse.api.repositories

import com.peterchege.retrofitcrashcourse.api.JsonPlaceholderApi
import com.peterchege.retrofitcrashcourse.api.responses.PostsResponse

class PostRepository(
    private val api:JsonPlaceholderApi
) {
    suspend fun getPosts():PostsResponse{
        return api.getAllPosts()

    }
}