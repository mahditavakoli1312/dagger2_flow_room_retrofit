package com.example.flow_1.core.di

import com.example.flow_1.core.data.Urls
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
object NetworkModules {

    @Provides
    @Named("base_url")
    fun provideBaseUrl(): String = Urls.BASE_URL

    @Provides
    fun provideRetrofit(@Named("base_url") baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}