package com.example.flow_1.feature.post.data.repository.impl

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.safeApiCall
import com.example.flow_1.feature.post.data.dataSource.remote.PostRemoteDataSource
import com.example.flow_1.feature.post.data.repository.PostRepository
import com.example.flow_1.feature.post.ui.model.PostView
import com.example.flow_1.feature.post.ui.model.toPostView
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource
) : PostRepository {
    override suspend fun getPostFromRemoteDataSource(): ResultWrapper<List<PostView>?> {
        return safeApiCall(
            api = {
                remoteDataSource.getPost()?.map { postBaseResponse ->
                    postBaseResponse.toPostView()
                }
            },
            localDataForErrorState = null
        )
    }
}