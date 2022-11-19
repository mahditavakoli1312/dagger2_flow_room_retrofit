package com.example.flow_1.feature.post.data.repository

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.flow_1.feature.post.ui.model.PostView
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPostsWithStrategy(): ResultWrapper<Flow<List<PostView>?>>
}