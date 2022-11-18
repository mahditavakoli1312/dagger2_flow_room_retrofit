package com.example.flow_1.core.di

import dagger.Component
import retrofit2.Retrofit

@Component(
    modules = [NetworkModules::class]
)
interface NetworkComponent {
    fun retrofit(): Retrofit

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}