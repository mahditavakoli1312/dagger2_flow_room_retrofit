package com.example.flow_1.core.di.module

import android.app.Application
import android.content.Context
import com.example.flow_1.core.common.DaggerApp
import dagger.Module
import dagger.Provides

@Module
object ContextModules {

    @Provides
    fun provideContext(app: DaggerApp): Context {
        return app.applicationContext
    }

    @Provides
    fun provideApplication(app: DaggerApp): Application {
        return app
    }
}



