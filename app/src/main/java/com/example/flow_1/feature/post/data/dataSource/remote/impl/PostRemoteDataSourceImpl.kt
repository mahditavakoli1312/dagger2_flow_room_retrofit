package com.example.flow_1.feature.post.data.dataSource.remote.impl

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.bodyOrThrow
import com.example.flow_1.feature.post.data.dataSource.remote.PostRemoteDataSource
import com.example.flow_1.feature.post.data.model.response.PostBaseResponse
import com.example.flow_1.feature.post.data.network.api.PostApi
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val postApi: PostApi
) : PostRemoteDataSource {
    override suspend fun getPost(): List<PostBaseResponse>? = postApi.getPost().bodyOrThrow()
}