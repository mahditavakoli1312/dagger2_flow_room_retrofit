package com.example.flow_1.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flow_1.feature.post.data.model.entity.PostEntity
import com.example.flow_1.feature.post.db.dao.PostDao

@Database(
    entities = [
        PostEntity::class
    ],
    version = 1
)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun getPostDao():PostDao
}