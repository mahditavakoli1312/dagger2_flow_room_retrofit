package com.example.flow_1.core.di.component

import com.example.flow_1.core.data.RoomScope
import com.example.flow_1.core.db.LocalDataBase
import com.example.flow_1.core.di.module.RoomModules
import com.example.flow_1.feature.post.di.PostComponent
import com.example.flow_1.feature.post.ui.fragment.PostFragment
import dagger.Component

@RoomScope
@Component(
    modules = [RoomModules::class],
    dependencies = [ContextComponent::class]
)
interface RoomComponent {

    fun LocalDataBase(): LocalDataBase
    @Component.Factory
    interface Factory {
        fun create(
            contextComponent: ContextComponent,
        ): RoomComponent
    }
}