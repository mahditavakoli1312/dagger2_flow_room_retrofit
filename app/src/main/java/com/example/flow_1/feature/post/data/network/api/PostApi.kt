package com.example.flow_1.feature.post.data.network.api

import com.example.flow_1.feature.post.data.model.response.PostBaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPost() : Response<List<PostBaseResponse>?>
}