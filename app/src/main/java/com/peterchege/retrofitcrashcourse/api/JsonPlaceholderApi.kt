package com.peterchege.retrofitcrashcourse.api



import com.peterchege.retrofitcrashcourse.api.responses.PostsResponse
import com.peterchege.retrofitcrashcourse.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getAllPosts():PostsResponse



    companion object {
        val instance by lazy {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(JsonPlaceholderApi::class.java)
        }
    }
}