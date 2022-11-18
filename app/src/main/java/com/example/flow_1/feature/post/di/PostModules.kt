package com.example.flow_1.feature.post.di

import com.example.flow_1.feature.post.data.dataSource.remote.PostRemoteDataSource
import com.example.flow_1.feature.post.data.dataSource.remote.impl.PostRemoteDataSourceImpl
import com.example.flow_1.feature.post.data.network.api.PostApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class PostModules {

    @Binds
    abstract fun providePostRemoteDataSource(impl: PostRemoteDataSourceImpl): PostRemoteDataSource

    companion object {
        @Provides
        fun providePostApi(retrofit: Retrofit): PostApi =
            retrofit.create(PostApi::class.java)
    }

}