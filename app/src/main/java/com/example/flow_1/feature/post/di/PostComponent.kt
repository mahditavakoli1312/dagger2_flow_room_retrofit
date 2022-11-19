package com.example.flow_1.feature.post.di

import com.example.flow_1.core.data.MainWithNetworkScope
import com.example.flow_1.core.di.NetworkComponent
import com.example.flow_1.feature.post.ui.fragment.PostFragment
import dagger.Component
@MainWithNetworkScope
@Component(
    modules = [PostModules::class],
    dependencies = [NetworkComponent::class]
)
interface PostComponent {

    fun inject(postFragment: PostFragment)

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent
        ): PostComponent
    }
}