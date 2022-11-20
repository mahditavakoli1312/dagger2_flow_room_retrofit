package com.example.flow_1.feature.post.data.repository.impl

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.safeApiCall
import com.example.flow_1.feature.post.data.dataSource.local.PostLocalDataSource
import com.example.flow_1.feature.post.data.dataSource.remote.PostRemoteDataSource
import com.example.flow_1.feature.post.data.model.entity.PostEntity
import com.example.flow_1.feature.post.data.model.entity.toPostEntity
import com.example.flow_1.feature.post.data.repository.PostRepository
import com.example.flow_1.feature.post.ui.model.PostView
import com.example.flow_1.feature.post.ui.model.toPostView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val localDataSource: PostLocalDataSource
) : PostRepository {

    suspend fun getPostFromRemoteDataSource(): ResultWrapper<List<PostView>?> {
        return safeApiCall(
            api = {
                remoteDataSource.getPost()?.map { postBaseResponse ->
                    postBaseResponse.toPostView()
                }
            },
            localDataForErrorState = null
        )
    }

    private fun _getPostEntityFromLocalDataSource(): Flow<List<PostView>?> =
        localDataSource.getPosts().map { list ->
            list?.map { postEntity ->
                postEntity.toPostView()
            }
        }

    private suspend fun _insertPostEntityToLocalDataSource(posts: List<PostEntity>) =
        localDataSource.insertPosts(posts = posts)

    private suspend fun _getPostsEntityFromRemoteDataSource(): List<PostEntity>? =
        remoteDataSource.getPost()?.map { postBaseResponse ->
            postBaseResponse.toPostEntity().copy(userId = (0..1000).random())
        }

    override suspend fun getPostsWithStrategy(): ResultWrapper<Flow<List<PostView>?>> {
        return safeApiCall(
            localDataForErrorState = _getPostEntityFromLocalDataSource(),
            api = {
                _getPostsEntityFromRemoteDataSource().let { remotePosts ->
                    _insertPostEntityToLocalDataSource(remotePosts!!)
                    return@safeApiCall _getPostEntityFromLocalDataSource()
                }

            }
        )
    }
}