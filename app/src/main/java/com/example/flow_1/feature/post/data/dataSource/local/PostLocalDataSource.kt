package com.example.flow_1.feature.post.data.dataSource.local

import com.example.flow_1.feature.post.data.model.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostLocalDataSource {
    fun getPosts() : Flow<List<PostEntity>?>
    suspend fun insertPosts(posts: List<PostEntity>)
}