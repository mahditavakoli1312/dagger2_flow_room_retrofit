package com.example.flow_1.feature.post.data.dataSource.remote

import com.example.flow_1.feature.post.data.model.response.PostBaseResponse

interface PostRemoteDataSource {
    suspend fun getPost() : List<PostBaseResponse>?
}