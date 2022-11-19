package com.example.flow_1.feature.post.di

import com.example.flow_1.core.data.MainWithNetworkScope
import com.example.flow_1.core.di.component.NetworkComponent
import com.example.flow_1.core.di.component.RoomComponent
import com.example.flow_1.feature.post.data.repository.PostRepository
import com.example.flow_1.feature.post.ui.fragment.PostFragment
import dagger.Component

@MainWithNetworkScope
@Component(
    modules = [PostModules::class],
    dependencies = [NetworkComponent::class,RoomComponent::class]
)
interface PostComponent {

    fun postRepository(): PostRepository
    fun inject(postFragment: PostFragment)

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            roomComponent: RoomComponent
        ): PostComponent
    }
}