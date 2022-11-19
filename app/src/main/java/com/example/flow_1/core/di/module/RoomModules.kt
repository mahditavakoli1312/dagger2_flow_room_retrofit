package com.example.flow_1.core.di.module

import android.content.Context
import androidx.room.Room
import com.example.flow_1.core.db.LocalDataBase
import dagger.Module
import dagger.Provides

@Module
object RoomModules {
    @Provides
    fun provideRoomDataBase(context: Context): LocalDataBase {
        return Room.databaseBuilder(context, LocalDataBase::class.java, "dagger_flow").build()

    }
}