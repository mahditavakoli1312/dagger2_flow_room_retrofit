package com.example.flow_1.core.di

import com.example.flow_1.core.data.NetworkScope
import dagger.Component
import retrofit2.Retrofit

@NetworkScope
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