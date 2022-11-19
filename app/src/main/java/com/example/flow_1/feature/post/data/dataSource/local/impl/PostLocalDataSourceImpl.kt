package com.example.flow_1.feature.post.data.dataSource.local.impl

import com.example.flow_1.feature.post.data.dataSource.local.PostLocalDataSource
import com.example.flow_1.feature.post.data.model.entity.PostEntity
import com.example.flow_1.feature.post.db.dao.PostDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostLocalDataSourceImpl @Inject constructor(
    private val postDao: PostDao
) : PostLocalDataSource {
    override fun getPosts(): Flow<List<PostEntity>?> =
        postDao.getPosts()

    override suspend fun insertPosts(posts: List<PostEntity>) = postDao.insertPosts(posts)


}