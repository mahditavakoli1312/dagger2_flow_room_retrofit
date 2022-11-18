package com.example.flow_1.feature.post.data.model.response

import com.google.gson.annotations.SerializedName

data class PostBaseResponse(
    @SerializedName("userId") val userId: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("body") val body: String?
)