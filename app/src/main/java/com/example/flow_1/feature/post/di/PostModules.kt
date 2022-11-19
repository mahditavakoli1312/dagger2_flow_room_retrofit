package com.example.flow_1.feature.post.di

import com.example.flow_1.core.db.LocalDataBase
import com.example.flow_1.feature.post.data.dataSource.local.PostLocalDataSource
import com.example.flow_1.feature.post.data.dataSource.local.impl.PostLocalDataSourceImpl
import com.example.flow_1.feature.post.data.dataSource.remote.PostRemoteDataSource
import com.example.flow_1.feature.post.data.dataSource.remote.impl.PostRemoteDataSourceImpl
import com.example.flow_1.feature.post.data.network.api.PostApi
import com.example.flow_1.feature.post.data.repository.PostRepository
import com.example.flow_1.feature.post.data.repository.impl.PostRepositoryImpl
import com.example.flow_1.feature.post.db.dao.PostDao
import com.example.flow_1.feature.post.ui.viewModel.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
abstract class PostModules {

    @Binds
    abstract fun providePostRemoteDataSource(impl: PostRemoteDataSourceImpl): PostRemoteDataSource

    @Binds
    abstract fun providePostRepository(impl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun providePostLocalDataSource(impl: PostLocalDataSourceImpl): PostLocalDataSource

    companion object {
        @Provides
        fun providePostApi(retrofit: Retrofit): PostApi =
            retrofit.create(PostApi::class.java)

        @Provides
        fun providePostDao(localDataBase: LocalDataBase): PostDao = localDataBase.getPostDao()

        @Provides
        fun providePostViewModel(postRepository: PostRepository): PostViewModel =
            PostViewModel(postRepository = postRepository)
    }

}