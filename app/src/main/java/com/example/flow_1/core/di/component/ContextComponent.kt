package com.example.flow_1.core.di.component

import android.content.Context
import com.example.flow_1.core.common.DaggerApp
import com.example.flow_1.core.data.ContextScop
import com.example.flow_1.core.di.module.ContextModules
import dagger.BindsInstance
import dagger.Component

@ContextScop
@Component(
    modules = [ContextModules::class]
)
interface ContextComponent {
    fun context(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            app: DaggerApp
        ): ContextComponent
    }
}