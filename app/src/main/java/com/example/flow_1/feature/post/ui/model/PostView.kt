package com.example.flow_1.feature.post.ui.model

import com.example.flow_1.feature.post.data.model.response.PostBaseResponse

data class PostView(
    val userId: Int?,
    val id: Int?,
    val title: String?,
    val body: String?
)

fun PostBaseResponse.toPostView() =
    PostView(
        userId = userId,
        id = id,
        title = title,
        body = body
    )