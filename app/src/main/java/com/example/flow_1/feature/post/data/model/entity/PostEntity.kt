package com.example.flow_1.feature.post.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flow_1.feature.post.data.model.response.PostBaseResponse

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "user_id") val userId: Int = -1,
    val title: String?,
    val body: String?
)

fun PostBaseResponse.toPostEntity() =
    PostEntity(
        userId = userId?:-2,
        title = title,
        body = body
    )