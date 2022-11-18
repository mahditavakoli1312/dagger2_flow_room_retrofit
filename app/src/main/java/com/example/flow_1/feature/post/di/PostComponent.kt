package com.example.flow_1.feature.post.di

import com.example.flow_1.core.di.NetworkComponent
import dagger.Component

@Component(
    modules = [PostModules::class],
    dependencies = [NetworkComponent::class]
)
interface PostComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent
        ): PostComponent
    }
}